package pl.edu.uj.javaframe;

import java.io.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class DataFrame {
    ArrayList<Series> columns = new ArrayList<>();

    public DataFrame(Class<? extends Value>[] types, String[] vals) {
        for (int i = 0; i < types.length; i++) {
            columns.add(new Series(types[i], vals[i]));

        }
    }

    public void addRow(String[] values) {
        for (int i = 0; i < columns.size(); i++) {
            columns.get(i).addValue(values[i]);
        }
    }

    public void head() {
        int rows = 0;
        for (int j = 0; j < columns.size(); j++) {
            System.out.print(columns.get(j).name + " ");
        }
        System.out.println();
        for (int j = 0; j < columns.get(0).values.size(); j++) {
            for (int i = 0; i < columns.size(); i++) {
                columns.get(i).values.get(j).print();
                System.out.print(' ');
            }
            System.out.println();
            rows++;
            if (rows > 5) {
                return;
            }
        }
    }


    public DataFrame iloc(int from, int to) {
        Class<? extends Value>[] types = new Class[columns.size()];
        String[] names = new String[columns.size()];
        for (int i = 0; i < columns.size(); i++) {
            types[i] = columns.get(i).type;
            names[i] = columns.get(i).name;
        }

        DataFrame result = new DataFrame(types, names);

        for (int i = from; i < to; i++) {
            String[] vals = new String[columns.size()];
            for (int ci = 0; ci < columns.size(); ci++) {
                vals[ci] = columns.get(ci).values.get(i).toString();
            }
            result.addRow(vals);
        }
        return result;
    }


    public static DataFrame readCSV(String path, Class<? extends Value>[] types) throws IOException {
        FileInputStream fstream = new FileInputStream(path);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        //Read File Line By Line
        DataFrame df = null;
        while ((strLine = br.readLine()) != null) {
            // Print the content on the console
            String[] row = strLine.split(",");
            if (df == null) {
                df = new DataFrame(types, row);
            } else {
                df.addRow(row);
            }


        }

        //Close the input stream
        br.close();

        return df;
    }

    public void apply(Applayable a, String name) {
        Series s = null;
        for (int i = 0; i < columns.size(); i++) {
            if (columns.get(i).name.equals(name)) {
                s = columns.get(i);
                break;
            }
        }
        a.apply(s);
    }

    private Series searchForSeries(String name) {
        for (Series series : columns) {
            if (series.name.equals(name)) {
                return series;
            }
        }
        return null;
    }

    /************************TODO***********************************/

    public Series apply(Applayable a, String name, int njobs) throws CSVException {

        Series s = searchForSeries(name);
        if(s==null){
            throw new CSVException("series is null!");
        }

        // okreslanie ile bedzie tych boxow
        int chunkSize = s.values.size() / njobs;
        ApplayableThread[] threads = new ApplayableThread[njobs];


        // przydzielam watki do chunkow/boxow danych
        for (int i = 0; i < njobs; i++) {
            int start = i * chunkSize;
            int end;
            if (i == njobs - 1) {
                end = s.values.size();
            } else {
                end = (i + 1) * chunkSize;
            }
            Series chunk = s.iloc(start, end);
            threads[i] = new ApplayableThread(chunk, a);
            threads[i].start();
        }

        try {
            // czekam na zakonczenie wszystkich watkow
            for (ApplayableThread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // tworze nowa serie z resultsami
        Series result = new Series(s.type, s.name);
        for (ApplayableThread thread : threads) {
            result.values.addAll(thread.result.values);
        }

        return result;
    }

    class ApplayableThread extends Thread {
        private Series result;
        private Applayable task;

        public ApplayableThread(Series s, Applayable task) {
            this.result = s;
            this.task = task;
        }

        @Override
        public void run() {
            task.apply(result);
        }
    }
}
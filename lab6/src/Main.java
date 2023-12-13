import pl.edu.uj.javaframe.*;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, CSVException {
        if (args.length != 4) {
            System.err.println("wrong usage");
            System.exit(1);
        }
        String filename = args[0];
        String columnName = args[1];
        int njobs = Integer.parseInt(args[2]);
        int index = Integer.parseInt(args[3]);
        DataFrame df = DataFrame.readCSV(filename, new Class[]{Int.class});
        Series result = df.apply(new Factorize(), columnName, njobs);
        System.out.println(result.values.get(index));
    }
}
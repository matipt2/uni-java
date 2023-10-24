package pl.edu.uj.javaframe;

public class MyDataFrame extends DataFrame {


    public MyDataFrame(Class<? extends Value>[] types, String[] vals) {
        super(types, vals);
    }

    public void print() {

        for (int i = 0; i < columns.size(); i++) {
            System.out.print(columns.get(i).name + "\t");
        }
        System.out.println();

        for (int i = 0; i < columns.get(0).values.size(); i++) {
            for (int j = 0; j < columns.size(); j++) {
                System.out.print(columns.get(j).values.get(i).toString() + "\t");
            }
            System.out.println();
        }
    }


}

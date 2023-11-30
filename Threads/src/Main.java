import java.lang.Thread;

public class Main {

    public static void main(String[]args){
//        Calculations ob1 = new Calculations();
//        Calculations ob2 = new Calculations();

        Thread ob1 = new Thread(new Calculations());
        Thread ob2 = new Thread(new Calculations());

        ob1.start();
        ob2.start();
    }


}
public class ThreadNames extends Thread{
    private static ThreadNames t1;
    private static ThreadNames t2;


    public static ThreadNames getT1() {
        return t1;
    }
    public static ThreadNames getT2() {
        return t2;
    }


    public void run(){
        while(true){
            System.out.println(getT1().getName());
            System.out.println(getT2().getName());
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }


    public static void main(String[] args){
        t1 = new ThreadNames();
        t2 = new ThreadNames();


        t1.start();
        t2.start();


    }
}

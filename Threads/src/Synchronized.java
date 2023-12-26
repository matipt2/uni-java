public class Synchronized extends Thread{
    private static int count = 0;

    public static synchronized void  incrementCount(){
        count++;
    }

    public void run(){
        for(int i=0;i<100;i++){
            incrementCount();
        }
    }

    public static void main(String[] args){
        Synchronized t1 = new Synchronized();
        Synchronized t2 = new Synchronized();
        Synchronized t3 = new Synchronized();
        Synchronized t4 = new Synchronized();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Wartosc: "+count);
    }
}

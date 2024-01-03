public class Calculations implements Runnable{
    private static int counter = 1;
    private static final Object lock = new Object();

    @Override
    public void run(){
        for(int i=0;i<=100;i++){
            synchronized(lock) {
                while(counter != Thread.currentThread().getId()) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(i+"."+" ID:"+ Thread.currentThread().getId());
                counter++;
                lock.notifyAll();
            }
        }
    }

    public static void main(String[]args) throws InterruptedException {
        Thread t1 = new Thread(new Calculations());
        Thread t2 = new Thread(new Calculations());
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}

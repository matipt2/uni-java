public class ThreadNamesExample extends Thread{

    public static void main(String[] args) throws InterruptedException {
        ThreadNamesExample t1 = new ThreadNamesExample();
        ThreadNamesExample t2 = new ThreadNamesExample();



        t1.start();
        t2.start();
        t1.join();
        t2.join();


    }

    public void run(){
        for(int i=0;i<5;i++){
                System.out.println(currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }


}

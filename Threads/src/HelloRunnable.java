public class HelloRunnable implements Runnable{
    public void run(){
        System.out.println("hello thread");
    }

    public static void main(String[]args){
        Thread t = new Thread(new HelloRunnable());
        t.start();
        System.out.println("hello from program");
    }
}

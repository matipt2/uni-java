public class HelloThread extends Thread{
    public void run(){
        System.out.println("hello thread");
    }

    public static void main(String[]args){
        Thread t = new HelloThread();
        t.start();
        System.out.println("hello from program");
    }
}

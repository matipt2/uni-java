public class LambdaThread {

    public static void main(String[] args) throws InterruptedException {

        Thread t = new Thread(() -> {
            synchronized (LambdaThread.class) {
                for (int i = 0; i < 10; i++)
                    System.out.println("hello" + i);
            }
        });
        t.start();

        Runnable r = () -> {
            synchronized (LambdaThread.class) {
                for (int k = 0; k < 10; k++)
                    System.out.println("world" + k);
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
    }
}

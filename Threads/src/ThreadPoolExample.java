import java.util.concurrent.*;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(2);

        Callable<Integer> myCallable = ()->{
            Thread.sleep(2000);
            return 42;
        };

        Future<Integer> future = es.submit(myCallable);

        try{
            Integer result = future.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            es.shutdown();
        }
    }
}

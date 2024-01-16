import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Executorssss

{
    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(2);
        es.execute(new Runnable(){
            @Override
            public void run(){
                for(int i=0;i<10000;i++){
                    System.out.println(i);
                }
            }
        });
        es.shutdown();
    }
}

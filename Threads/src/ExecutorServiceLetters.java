import java.util.ArrayList;
import java.util.concurrent.*;

public class ExecutorServiceLetters implements Callable<String> {
    private String letter;

    public ExecutorServiceLetters(String letter){
        this.letter = letter;
    }

    public String call(){
        return this.letter;
    }


    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        ExecutorService es = Executors.newFixedThreadPool(5);
        ArrayList<Future<String>> futures = new ArrayList<>();

        for(String letter: letters){
            Future<String> future = es.submit(new ExecutorServiceLetters(letter));
            futures.add(future);
        }

        for(Future<String> future: futures){
            try{
                System.out.println(future.get());
            }catch(ExecutionException e){
                e.printStackTrace();
            }
        }
        es.shutdown();

    }
}


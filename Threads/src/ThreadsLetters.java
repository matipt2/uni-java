import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class ThreadsLetters extends Thread{
    private String letter;

    public void run(){
        System.out.println(this.letter);
    }

    public ThreadsLetters(String letter){
        this.letter = letter;
    }

    public static void main(String[] args) throws InterruptedException {
        ArrayList<String> letters = new ArrayList<>();
        letters.add("A");
        letters.add("B");
        letters.add("C");
        letters.add("D");
        letters.add("E");

        for(String letter: letters){
            ThreadsLetters t = new ThreadsLetters(letter);
            t.start();
            t.join();
        }

    }
}

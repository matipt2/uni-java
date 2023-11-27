import java.io.*;

public class Main {
    public static void main(String[] args) {

        try {
            String inputFilePath = args[0];
            String outputFilePath = args[1];
            int delay = Integer.parseInt(args[2]);
            int fps = Integer.parseInt(args[3]);
            MicroDVDDelay.delay(inputFilePath, outputFilePath, delay, fps);
        }
        catch(MicroException e){
            System.out.println(e.getErrorLine());
        }
        catch(Exception e){
            System.out.println("unknown exception: "+ e.getMessage());
        }
    }

}
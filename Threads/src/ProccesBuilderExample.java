import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProccesBuilderExample {
    public static void main(String[] args){

        String komenda = "ping www.google.com";


        try{Process process = new ProcessBuilder(komenda).start();
           BufferedReader bri = new BufferedReader(new InputStreamReader(process.getInputStream()));
           String line;
           while((line =bri.readLine())!=null){
               System.out.println(line);
           }
           bri.close();
            process.waitFor();
        }catch(IOException | InterruptedException e){
            e.printStackTrace();

        }
    }
}

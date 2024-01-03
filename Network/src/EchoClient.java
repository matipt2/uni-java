import java.io.*;
import java.net.Socket;

public class EchoClient{
    public static void main(String[] args) throws IOException {

        try(
            Socket s = new Socket("localhost",5000);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        ){
            String line;
            while((line=br.readLine())!=null){
                bw.write(line);
                System.out.println("i send this message: "+ line);
            }

        }catch (IOException e){
            e.printStackTrace();
        }

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
        t.start();

    }
}

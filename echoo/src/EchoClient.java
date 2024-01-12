import java.io.*;
import java.net.Socket;

public class EchoClient{
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",6200);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            String line;
            while((line=br.readLine())!=null){

                bw.write(line);
                bw.flush();
            }
            br.close();
            bw.close();
            s.close();
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
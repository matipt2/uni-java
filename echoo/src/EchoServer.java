import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {

        try{
            ServerSocket ss = new ServerSocket(6500);
            Socket s = ss.accept();
            BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

            while(true){
                String line;
                while((line=br.readLine())!=null){
                    bw.write(line);
                    bw.flush();
                }
                s.close();
                bw.close();
                br.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }


    }
}
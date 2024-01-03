import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (
                ServerSocket ss = new ServerSocket(5000);
                Socket s = ss.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
        ) {
            while (true) {


                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    bw.write(line);
                }
                s.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
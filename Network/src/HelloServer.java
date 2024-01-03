import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(5000);
        Socket s = ss.accept();

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));

        bw.write("hello\n");
        bw.flush();

        s.close();
        ss.close();

    }
}

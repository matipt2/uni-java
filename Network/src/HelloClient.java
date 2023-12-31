import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost", 5000);

        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));

        String line = br.readLine();
        System.out.println(line);

        s.close();
    }
}

import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SSLServer {
    public static void main(String[] args) throws IOException {
        SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket ss = (SSLServerSocket) factory.createServerSocket(9999);
        SSLSocket s = (SSLSocket) ss.accept();
        BufferedReader br= new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line;

        while((line=br.readLine())!=null){
            System.out.println(line);
            System.out.flush();

        }
    }
}

import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;

public class SSLClient {
    public static void main(String[] args) throws IOException {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        SSLSocket s = (SSLSocket) factory.createSocket("localhost", 9999);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        OutputStreamWriter osw = new OutputStreamWriter(s.getOutputStream());
        BufferedWriter bw = new BufferedWriter(osw);
        String line;
        while((line=br.readLine())!=null){
            bw.write(line);
            bw.flush();
        }

    }
}

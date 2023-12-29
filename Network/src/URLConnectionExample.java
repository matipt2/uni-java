import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionExample {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.pl/");
        URLConnection con = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String line;
        while((line=in.readLine())!=null){
            System.out.println(line);
        }
        in.close();
    }
}

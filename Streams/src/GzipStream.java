import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.zip.GZIPOutputStream;

public class GzipStream {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        GZIPOutputStream gos = new GZIPOutputStream(new FileOutputStream(args[0]));

        while(sc.hasNext()){
            String s = sc.nextLine()+"\n";
            gos.write(s.getBytes());
        }
        sc.close();
        gos.close();
    }
}

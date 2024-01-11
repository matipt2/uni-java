import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) throws IOException {
        Properties p;
        p = System.getProperties();
        p.list(System.out);
        p.load(new FileInputStream("ustawienia.txt"));
        p.storeToXML(new FileOutputStream("ustawienia.txt"), "");



    }
}

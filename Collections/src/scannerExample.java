import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class scannerExample {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        FileWriter fw = new FileWriter("pliktestowy.txt");
        fw.write(input);
        fw.close();

    }
}

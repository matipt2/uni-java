import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Cryptographer {
    public static void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm) {
        BufferedReader reader;
        FileWriter myWriter;

        try {
            reader = new BufferedReader(new FileReader(path_to_file_in)); //reader, aby odczytac tekst z pliku
            myWriter = new FileWriter(path_to_file_out); //FileWriter aby wczytac juz cryptedLine do nowego pliku txt

            String line = reader.readLine();

            while (line != null) {
                String encryptedLine = algorithm.crypt(line);
                myWriter.write(encryptedLine + "\n");
                line = reader.readLine();
            }

            reader.close();
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm){

    }


}

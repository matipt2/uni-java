import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Cryptographer {
        public static void cryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm){
            try{
                List<String> lines = Files.readAllLines(Paths.get(path_to_file_in));
                lines.replaceAll(algorithm::crypt);
                Files.write(Paths.get(path_to_file_out),lines);
            } catch (IOException e) {
                throw new RuntimeException("something went wrong",e);
            }
        }

    public static void decryptfile(String path_to_file_in, String path_to_file_out, Algorithm algorithm){
        try{
            List<String> lines = Files.readAllLines(Paths.get(path_to_file_in));
            lines.replaceAll(algorithm::decrypt);
            Files.write(Paths.get(path_to_file_out),lines);
        } catch (IOException e) {
            throw new RuntimeException("something went wrong",e);
        }
    }


}

import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JFileChooserTest extends JFrame {

    public static void main(String[] args){
        JFileChooser jFileChooser = new JFileChooser();
        int returnInput = jFileChooser.showOpenDialog(null);

        if(returnInput == JFileChooser.APPROVE_OPTION) {
            File selectedFile = jFileChooser.getSelectedFile();
            try {
                BufferedReader br = new BufferedReader(new FileReader(selectedFile));
                String line;
                while((line=br.readLine())!=null){
                    System.out.println(line);
                }

            }catch(IOException e){
                e.printStackTrace();
            }
        }

    }
}

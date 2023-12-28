import javax.swing.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class JFileChooserHello extends JFrame {

    public static void main(String[] args) throws IOException {
        JFileChooser jFileChooser = new JFileChooser();
        int returnInput = jFileChooser.showOpenDialog(null);

        if(returnInput==JFileChooser.APPROVE_OPTION){
            File selectedFile = jFileChooser.getSelectedFile();
            FileWriter fr = new FileWriter(selectedFile);
            fr.write("Hello");
            fr.close();

        }
    }
}

import javax.swing.*;
import java.io.*;

public class JFileChooooooooser extends JFrame{
    public static void main(String[] args) throws IOException {
        JFrame frame = new JFrame("JFilechooser example");
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JFileChooser chooser = new JFileChooser();
        int returnType = chooser.showOpenDialog(frame);

        if(returnType == JFileChooser.APPROVE_OPTION){
            File selectedFile = chooser.getSelectedFile();
            BufferedReader br = new BufferedReader(new FileReader(selectedFile));

            String line;
            while((line=br.readLine())!=null){
                System.out.println(line);
            }

        }



        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class S33 extends JFrame{

    static void createAndShowGUI(String tekst){
        JFrame frame = new JFrame("TEKST");
        frame.setLayout(new FlowLayout());
        JTextField text2 = new JTextField(tekst);
        frame.getContentPane().add(text2);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String tekst = scanner.nextLine();
        
        SwingUtilities.invokeLater(()->createAndShowGUI(tekst));
    }
}

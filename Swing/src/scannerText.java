import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class scannerText extends JFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JFrame frame = new JFrame("okno z przyciskiem");


        String input = scanner.nextLine();

        JTextField textField = new JTextField();
        textField.add(null, input);



        frame.getContentPane().add(textField);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

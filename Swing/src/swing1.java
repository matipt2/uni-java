import javax.swing.*;
import java.awt.*;
//3 buttony pionowo
public class swing1 extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setTitle("test");

        JButton button = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(button);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;

public class ThreeButtons extends JFrame {
    public static void main(String[] args){
        JFrame frame = new ThreeButtons();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JButton b1 = new JButton("BUTTON1");
        JButton b2 = new JButton("BUTTON2");
        JButton b3 = new JButton("BUTTON3");
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        frame.getContentPane().add(panel);
        frame.setVisible(true);
    }
}

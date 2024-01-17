import javax.swing.*;

public class textarea extends JFrame {
    public static void main(String[] args) {
        JFrame frame = new JFrame("test");
        frame.setTitle("test");
        JTextField test1 = new JTextField();
        JTextField test2 = new JTextField();
        JTextField test3 = new JTextField();

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        frame.getContentPane().add(test1);
        frame.getContentPane().add(test2);
        frame.getContentPane().add(test3);

        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}

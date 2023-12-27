import javax.swing.*;

public class JButtonExample extends JFrame {
    public static void main(String[] args)  {
        JButtonExample frame = new JButtonExample();
        frame.setSize(300,300);
        JButton button = new JButton("click me!");
        frame.add(button);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextDisplayApp2 extends JFrame {

    public TextDisplayApp2(){
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        TextArea textArea = new TextArea();
        JButton button = new JButton("click to input text");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Wpisz tu: ");
                textArea.append(input + "\n");
            }
        });
        frame.add(button, BorderLayout.NORTH);
        frame.add(textArea, BorderLayout.CENTER);
        frame.setVisible(true);
    }
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextDisplayApp2();
            }
        });
    }
}

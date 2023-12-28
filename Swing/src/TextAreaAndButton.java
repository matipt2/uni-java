import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextAreaAndButton extends JFrame {

    public TextAreaAndButton(){
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JTextField textField = new JTextField();
        JButton button = new JButton("print text");



        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(button == e.getSource()){
                    String input = textField.getText();
                    System.out.println(input);
                }
            }
        });

        panel.add(button);
        panel.add(textField);
        getContentPane().add(panel);
        setVisible(true);

    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new TextAreaAndButton();
            }
        });
    }
}

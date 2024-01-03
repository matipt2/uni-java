import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JOptionPaneExample2 extends JFrame {

    public JOptionPaneExample2(){
        JFrame frame = new JFrame();
        frame.setSize(300,300);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton button = new JButton();
        frame.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(button == e.getSource()){
                    JOptionPane.showMessageDialog(null,"Hello");
                }
            }
        });


        frame.setVisible(true);
    }

    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JOptionPaneExample2();
            }
        });

    }
}

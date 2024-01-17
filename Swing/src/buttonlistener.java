import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class buttonlistener {
    public static void main(String[] args) {
        JFrame frame = new JFrame("okno z przyciskiem");
        JButton button = new JButton("Kliknij");

        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                JOptionPane.showMessageDialog(null, "hellO");
            }
        });

        frame.getContentPane().add(button);

        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }
}

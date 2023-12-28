

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class TextDisplayApp extends JFrame{


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        JFrame frame = new JFrame();
        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        JTextArea textArea = new JTextArea(line);

        frame.add(textArea);

        frame.setVisible(true);


    }
}


import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XMLEncoderDecoder {
    public static void main(String[] args) throws Exception{
        //encode
        XMLEncoder e = new XMLEncoder(new FileOutputStream("jbutton.xml"));
        e.writeObject(new JButton("Hello world"));
        e.close();

        //decode
        XMLDecoder d = new XMLDecoder(new FileInputStream("jbutton.xml"));
        String obj = d.readObject().toString();
        d.close();
        System.out.println(obj);


    }
}

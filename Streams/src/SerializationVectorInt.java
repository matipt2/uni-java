import java.io.*;
import java.util.Vector;

public class SerializationVectorInt implements Serializable {
    private Vector<String> vector;
    private int number;

    public SerializationVectorInt(Vector vector, int number) {
        this.vector = vector;
        this.number = number;
    }

    public static void main(String[] args) {
        try {
            Vector<String> stringVector = new Vector<>();
            stringVector.add("lorem");
            stringVector.add("ipsum");
            int number = 32;
            SerializationVectorInt st1 = new SerializationVectorInt(stringVector, number);
            ObjectOutputStream oos= new ObjectOutputStream(new FileOutputStream("output_object"));
            oos.writeObject(st1);
            oos.close();

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output_object"));
            SerializationVectorInt st2 = (SerializationVectorInt) ois.readObject();
            ois.close();

            System.out.println("vector: "+ st2.vector);
            System.out.println("number: "+st2.number);

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

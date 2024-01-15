import java.io.*;
import java.security.SecureRandom;
import java.util.Vector;

public class SerializationExamplee implements Serializable{
    private int value;
    private Vector<Integer> vector;

    public SerializationExamplee(int value, Vector<Integer> vector) {
        this.value = value;
        this.vector = vector;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Vector<Integer> getVector() {
        return vector;
    }

    public void setVector(Vector<Integer> vector) {
        this.vector = vector;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Vector<Integer> v = new Vector<>();
        v.add(5);
        v.add(7);
        SerializationExamplee se = new SerializationExamplee(15, v);


        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("vectorint.bin"));
        oos.writeObject(se);
        oos.close();

        //deserialize

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("/Users/mateuszptasik/Desktop/JavaLAB2023/Collections/vectorint.bin"));
        SerializationExamplee deserialize;
        deserialize = (SerializationExamplee) ois.readObject();
        System.out.println(deserialize.getValue());

        for(Integer ints: deserialize.getVector()){
            System.out.println(ints);
        }


    }

}

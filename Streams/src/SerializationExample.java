import java.io.*;

public class SerializationExample implements Serializable{
    public int id;
    public String name;

    public SerializationExample(int i, String s){
        this.id = i;
        this.name = s;
    }
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        SerializationExample st1 = new SerializationExample(12, "lorem");
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("output_object"));
        oos.writeObject(st1);
        oos.close();

        SerializationExample st2;
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("output_object"));
        st2 = (SerializationExample)ois.readObject();
        ois.close();
        System.out.println(st2.id+"\t"+ st2.name);

    }
}

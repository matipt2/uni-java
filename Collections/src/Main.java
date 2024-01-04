import java.util.Vector;

public class Main implements Cloneable{
    public static void main(String[] args) {
        Vector<Integer> vector = new Vector<>();
        vector.add(3);
        vector.add(4);
        System.out.println(vector);
        Vector<Integer> clonedVector = (Vector<Integer>) vector.clone();
        clonedVector.add(55);
        System.out.println(clonedVector);
    }
}
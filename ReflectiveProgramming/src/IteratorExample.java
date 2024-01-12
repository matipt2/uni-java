
import java.util.Iterator;
import java.util.Vector;
public class IteratorExample {

    public static void main(String[] args) {
        Vector<Integer> v = new Vector<>();
        v.add(3);
        v.add(4);
        Iterator<Integer> it = v.iterator();

        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}

import java.util.Collections;
import java.util.Vector;

class MyString implements Comparable<MyString> {
    private String value;

    public MyString(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public int compareTo(MyString other) {
        return Integer.compare(this.value.length(), other.value.length());
    }

    @Override
    public String toString() {
        return value;
    }
}

public class ComparableExample {
    public static void main(String[] args) {
        Vector<MyString> v = new Vector<>();
        v.add(new MyString("lotasiet"));
        v.add(new MyString("Xd"));
        v.add(new MyString("dddddddddddd"));

        Collections.sort(v);

        for (MyString myString : v) {
            System.out.println(myString);
        }
    }
}

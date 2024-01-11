import java.util.ResourceBundle;

public class ResourceBundleExample {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("resources");
        for(String key: rb.keySet()){
            System.out.println(rb.getString(key));
        }
    }
}

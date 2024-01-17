import java.io.OutputStream;
import java.lang.reflect.Method;

public class getMethodsFromClass {
    public static void main(String[] args) {
        Class<?> otpStream = OutputStream.class;
        Method[] methods = otpStream.getMethods();

        for(Method metoda: methods){
            System.out.println(metoda);
        }

    }
}

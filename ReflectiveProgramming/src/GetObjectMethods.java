import java.io.OutputStream;
import java.lang.reflect.Method;

public class GetObjectMethods {
    public static void main(String[] args) {
        Class<?> outputStreamClass = OutputStream.class;
        Method[] methods = outputStreamClass.getDeclaredMethods();


        for(Method method: methods){
            System.out.println("Name: "+method.getName()+" Type: "+method.getReturnType());
        }

        Class<?> objectClass = Object.class;
        Method[] objectMethods = objectClass.getMethods();
        for(Method method: objectMethods){
            System.out.println("Name: "+method.getName()+" Type: "+method.getReturnType());
        }
    }
}

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class A {
    private int b = 7;
    public int getB(){
        return b;
    }
    public static void main(String[] args) throws NoSuchFieldException, InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {


        Class<?> c = A.class;
        A instanceOfA = (A) c.newInstance();
        Field field = c.getDeclaredField("b");
        field.setInt(instanceOfA, 52);

        System.out.println(instanceOfA.getB());





    }
    public void shout(String d){
        System.out.println(d);
    }
}

import java.lang.reflect.Method;
import java.sql.Ref;
import java.sql.SQLOutput;

public class ReflectiveHello {
    public ReflectiveHello(){

    }
    public static void main(String[] args) {
        ReflectiveHello reflectiveHello = new ReflectiveHello();

        try{
            String argument = "Hello";
            Class<?> fetchedClass = reflectiveHello.getClass();
            Method method = fetchedClass.getDeclaredMethod("exampleOfMethod", String.class);
            Method secondMethod = fetchedClass.getDeclaredMethod("secondExample", String.class);
            method.invoke(reflectiveHello, argument);
            secondMethod.invoke(reflectiveHello, argument);

            Method numberMethod = fetchedClass.getDeclaredMethod("numbers", int.class, int.class);
            numberMethod.invoke(reflectiveHello,3,5);
        }catch(Exception e){
            e.printStackTrace();
        }

    }

    private void exampleOfMethod(String argument){
        System.out.println("should print hello, has: "+argument);
    }

    public void secondExample(String argument){
        System.out.println("should print hello, has: "+argument);
    }

    public int numbers(int number1, int number2){
        int sum = number1+number2;
        System.out.println(sum);
        return sum;
    }

}

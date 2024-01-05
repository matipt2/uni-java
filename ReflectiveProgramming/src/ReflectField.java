import java.lang.reflect.Field;
import java.sql.Ref;
public class ReflectField {
    private int number;

    public ReflectField(){

    }
    public int getNumber(){
        return number;
    }

    public static void main(String[] args) {
        try{
            Class<?> reflectClass = Class.forName("ReflectField");
            ReflectField myClassInstance = (ReflectField) reflectClass.getDeclaredConstructor().newInstance();

            Field field = reflectClass.getDeclaredField("number");
            field.setInt(myClassInstance, 15);
            System.out.println(myClassInstance.getNumber());
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

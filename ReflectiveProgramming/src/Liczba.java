import java.lang.reflect.Field;

public class Liczba {
    int l=7;
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Liczba liczba = new Liczba();
        Field field = Liczba.class.getDeclaredField("l");
        field.setInt(liczba,42);
        System.out.println(liczba.l);
    }
}

import java.util.List;

public class Wildcard {
    public Wildcard(){

    }

    public static void printList(List<?> list){
        for(Object elements: list){
            System.out.println(elements+ " ");
        }
        System.out.println();
    }

    public static double sumList(List<? extends Number> list){
        double result = 0;
        for(Number elements: list){
            result+=elements.doubleValue();
        }
        return result;
    }


}

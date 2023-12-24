import java.util.ArrayList;
import java.util.List;

public class Generics {

    public static void main(String[] args) {

        GenericPrinter<Integer> integerPrinter = new GenericPrinter<>(13);
        GenericPrinter<String> stringPrinter = new GenericPrinter<>("loremipsum");
        GenericPrinter<Double> doublePrinter = new GenericPrinter<>(5.23);
        integerPrinter.print();
        stringPrinter.print();
        doublePrinter.print();

        shout(23);
        shout("lorem");
        anotherShout(24,43);
        anotherShout("ddd", 5);

        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        intList.add(15);
        printList(intList);


        
    }

    private static <T> void shout(T thingToShout){
        System.out.println(thingToShout+"!");
    }
    private static <T,V> void anotherShout(T thingToShout, V anotherThingToShouut){
        System.out.println(thingToShout+"!!");
        System.out.println(anotherThingToShouut+"!!");
    }

    private static void printList(List<?> myList){
        System.out.println(myList);
    }
}

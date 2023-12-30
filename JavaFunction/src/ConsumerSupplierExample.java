import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsumerSupplierExample {
    public static void main(String[] args){

        Consumer<Integer> cons = x -> {System.out.println(x);};
        cons.accept(23);
        Supplier<Integer> sup = () -> 7;
        System.out.println(sup.get());
        int power = power2.apply(12);
        System.out.println(power);

    }

    static Function<Integer, Integer> power2 = number -> number*number;

}

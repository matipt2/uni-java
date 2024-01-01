import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public class BiFunctionExample {
    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7);
        BiFunction<List<Integer>, List<Integer>, List<Integer>> multiplyFunction = (x,y) -> x*y;

        Stream.of(list1,list2)
                .flatMap(List::stream)
                .filter(number -> number%2==0)
                .forEach(System.out::println);

        multiplyFunction(list1,list2);
    }


}

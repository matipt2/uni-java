import java.util.Arrays;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamBiFunctionExample {
    public static void main(String[] args){
        List<Integer> list1 = Arrays.asList(1,2,3,4,5);
        List<Integer> list2 = Arrays.asList(3,4,5,6,7);


        Stream.of(list1,list2)
                .flatMap(List::stream)
                .filter(number -> number%2==0)
                .forEach(System.out::println);

        Stream.of(5,7,2,4)
                .map(number -> number*number)
                .forEach(System.out::println);

        String sentence = Stream.of("lorem","ipsum")
                .collect(Collectors.joining(" "));
        System.out.println(sentence);

        Integer sum = Stream.of(1,2,3,4,5)
                .reduce(0,Integer::sum);
        System.out.println(sum);

        Vector<Integer> vecObj = new Vector<>();
        vecObj.add(2);
        vecObj.add(3);
        vecObj.add(6);
        vecObj.add(9);
        vecObj.add(14);
        vecObj.forEach(System.out::println);
        Stream.of(vecObj)
                .forEach(System.out::println);
    }
}

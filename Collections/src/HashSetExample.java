import java.util.*;

public class HashSetExample
{
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(3);
        set.add(2);
        set.add(6);
        set.add(15);
        System.out.println(set.contains(3));
        System.out.println(set.isEmpty());

        for(Integer numbers: set){
            System.out.println(numbers);
        }

        set.forEach(System.out::println);
        Iterator<Integer> integerIterator = set.iterator();
        while(integerIterator.hasNext()){
            System.out.println(integerIterator.next());
        }

        List<Integer> list1 = new ArrayList<>();
        list1.add(432);
        list1.add(532);
        list1.add(43);
        list1.add(23);

        set.addAll(list1);

        set.forEach(System.out::println);

    }
}

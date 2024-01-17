import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class f1 {
    public static void main(String[] args) {
//        Thread t = new Thread(()-> System.out.println("hello"));
//        t.start();

//        Runnable r = () -> System.out.println("hello");
//        Thread t = new Thread(r);
//        t.start();

        Thread t = new Thread(new Runnable(){
           public void run(){
               System.out.println("hi hi hi hi");
           }
        });
        t.start();

        Runnable r  = () -> {
            System.out.println("lotasiet");
        };
        r.run();

        Consumer<Integer> cons = x ->{
            System.out.println(x);
        };
        cons.accept(15);

        Supplier<Integer> sup = ()->14;
        System.out.println(sup.get());

        Function<Integer,Integer> increment = x->x+1;
        System.out.println(increment.apply(15));

        BiFunction<Integer, Integer, Integer> sum = (x,y) -> x+y;
        System.out.println(sum.apply(2,3));

        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(6);

        list.forEach(x-> System.out.println(x));

        BiFunction<String,String,String> addStrings = (x,y)->x+y;
        String c = addStrings.apply("jeden","dwa");
        System.out.println(c);

        HashMap<String,Integer> hashMap = new HashMap<>();
        hashMap.put("b", 5);
        hashMap.put("a", 3);

        List<String> sortedKeys = hashMap.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        for(String klucz: sortedKeys){
            System.out.println(klucz);
        }

        Function<Integer,Integer> b = x->x+1;
        System.out.println(b.apply(2));
        

   
        

        




    }

}

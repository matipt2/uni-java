import java.util.ArrayList;
import java.util.List;

public class main2 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(3);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(12);

        for(int i=0;i<5;i++){

            if(i==3){
                System.out.println("break at 3 iteration");
                break;
            }
            System.out.println(list.get(i));

        }

    }
}

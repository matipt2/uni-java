import java.sql.Array;
import java.util.Arrays;

public class SortArgs{
    public static void main(String[] args) {
        String arg1 = "b";
        String arg2 = "a";
        String arg3 = "g";
        String arg4 = "z";

        String[] arr = new String[4];
        arr[0]=arg1;
        arr[1]=arg2;
        arr[2]=arg3;
        arr[3]=arg4;

        Arrays.sort(arr);
        for(String arg: arr){
            System.out.println(arg);
        }

        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }


    }

}

import java.util.HashMap;
import java.util.Map;

public class ArgsLength {
    public static void main(String[] args) {
        Double[] arg = new Double[3];
        double arg1 = 5;
        double arg2 = 16;
        double arg3 = 15;
        arg[0]=arg1;
        arg[1]=arg2;
        arg[2]=arg3;
        double sum=0;
        double srednia;
        for(int i=0;i<arg.length;i++){
            sum+=arg[i];
        }
        srednia = sum/arg.length;
        System.out.println(srednia);

        Map<String, Integer> hmp = new HashMap<>();
        hmp.put("piec",5);
        hmp.put("trzy",3);

        for(Map.Entry<String, Integer> entry : hmp.entrySet()){
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }
        hmp.forEach((key,value) -> System.out.println(key+" "+value));
    }
}

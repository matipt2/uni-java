import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {

        Map<String,Integer> hashMap = new HashMap<>();
        hashMap.put("Mateusz",123);
        hashMap.put("Kacper", 321);
        hashMap.put("Filip",456);
        System.out.println(hashMap.get("Filip"));

        for(Map.Entry<String,Integer> entry: hashMap.entrySet()){
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Key: "+key+" Value: "+value);
        }
    }
}

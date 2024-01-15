import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        Vector<Integer> v = new Vector<>();
//        v.add(3);
//        v.add(5);
//        v.add(7);
//
//        Iterator it = v.iterator();
//        while(it.hasNext()){
//            System.out.println(it.next());
//        }
//        Enumeration e = v.elements();
//        while(e.hasMoreElements()){
//            System.out.println(e.nextElement());
//        }
//        for(Integer number: v){
//            System.out.println(number);
//        }
//        for(int i =0;i<v.size();i++){
//            System.out.println(v.get(i));
//        }
//        p.list(System.out);
//        FileOutputStream fileOutputStream = new FileOutputStream("plik.properties");
//        p.store(fileOutputStream,"");

        HashMap<Integer,Integer> hashMap = new HashMap<>();
//        Properties p = new Properties();
//        FileInputStream fileInputStream = new FileInputStream("/Users/mateuszptasik/Desktop/JavaLAB2023/test/src/plikson.txt");
//        p.load(fileInputStream);
//        p.list(System.out);
//        FileOutputStream fileOutputStream = new FileOutputStream("plik.xml");
//        p.storeToXML(fileOutputStream,"testy testy");
        hashMap.put(1,2);
        hashMap.put(3,4);

        for(Map.Entry<Integer,Integer> number: hashMap.entrySet()){
            System.out.println(number);
        }

        hashMap.forEach((key,value)-> System.out.println(key+" "+value));










    }
}
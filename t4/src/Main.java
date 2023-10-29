public class Main {

    public static void main(String[] args) {
        Polibiusz poli = new Polibiusz();
        ROT11 rot11 = new ROT11();


        System.out.println(poli.crypt("LOL"));
        System.out.println(poli.decrypt("15 22 15"));
        System.out.println(rot11.crypt("lol"));
        System.out.println(rot11.decrypt("wzw"));
    }
}
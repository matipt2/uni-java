public class Main {
    public static void main(String[] args) {

        Pesel pesel1 = new Pesel(args[0]);
        Pesel pesel2 = new Pesel(args[1]);
        System.out.println("Pesel 1:"+args[0]);
        System.out.println("Pesel 2:"+args[1]);

        Pesel.check(pesel1);
        Pesel.check(pesel2);
        Pesel.compare(pesel1, pesel2);

    }
}
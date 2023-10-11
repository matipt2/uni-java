public class Main {
    public static void main(String[] args) {
        if (args.length == 1) {
            Pesel pesel1 = new Pesel(args[0]);
            pesel1.check();
        } else if (args.length == 2) {
            Pesel pesel1 = new Pesel(args[0]);
            Pesel pesel2 = new Pesel(args[1]);
            pesel1.compare(pesel2);
        } else {
            System.out.println("Nieprawidłowe argumenty");
        }
    }
}
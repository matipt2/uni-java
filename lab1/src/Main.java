import pl.edu.uj.java.Pesel;

public class Main {
    public static void main(String[] args) {
        if (args.length == 1) { //compare
            Pesel peselObj = new Pesel(args[0]);
            boolean isValid = Pesel.check(peselObj); //sprawdz czy poprawny
            if (isValid) {

                System.out.println("1");
            } else {
                System.out.println("0");
            }
        } else if (args.length == 2) { //check
            Pesel pesel1 = new Pesel(args[0]); //tworzenie dwoch nowych obiektow PESEL
            Pesel pesel2 = new Pesel(args[1]);
            boolean areEqual = pesel1.compare(pesel2);
            if (areEqual) {
                System.out.println("1");

            } else {
                System.out.println("0");
            }
        } else {
            System.out.println("invalid arguments");

        }
    }
}

public class Pesel {
    private String pesel;

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean compare(Pesel anotherPesel) {
        boolean areEqual = this.pesel.equals(anotherPesel.pesel);
        return areEqual;
    }

    public static boolean check(String pesel) {
        if (pesel.length() != 11) {
            return false;
        }

        int sum = 0;
        int[] waga = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3};

        for (int i = 0; i < 10; i++) {
            int index = Character.getNumericValue(pesel.charAt(i)); //getNumericValue, zeby zamienic Stringi na cyfry
            sum += waga[i] * index;
        }

        int kontrolna = 10 - (sum % 10);
        if (kontrolna == 10) {
            kontrolna = 0;
        }

        int cyfraKontrolna = Character.getNumericValue(pesel.charAt(10));
        return kontrolna == cyfraKontrolna;
    }

}
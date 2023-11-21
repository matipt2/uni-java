package pl.edu.uj.java;
public class Pesel {
    private String pesel;

    public String getPesel() {
        return pesel;
    } //getter

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean compare(Pesel anotherPesel) {
        if (!check(this) || !check(anotherPesel)) { // sprawdzenie, czy sa prawidlowe przed porownaniem
            return false;
        }
        boolean areEqual = this.pesel.equals(anotherPesel.pesel);
        return areEqual;
    }

    public static boolean check(Pesel pesel) {
        String peselStr = pesel.getPesel();
        if (peselStr.length() != 11) {
            return false;
        }

        int sum = 0;
        int[] waga = {1, 3, 7, 9, 1, 3, 7, 9, 1, 3}; //wagi z wikipedii

        for (int i = 0; i < 10; i++) {
            int index = Character.getNumericValue(peselStr.charAt(i)); //getNumericValue, zeby zamienic Stringi na cyfry
            if(index<0 || index>9){ //sprawdzenie czy w Peselu znajduja sie tylko cyfry
                return false;
            }
            sum += waga[i] * index;
        }

        int kontrolna = 10 - (sum % 10);
        if (kontrolna == 10) { // w razie przypadku szczegolnego z wikipedii
            kontrolna = 0;
        }

        int cyfraKontrolna = Character.getNumericValue(peselStr.charAt(10));
        return kontrolna == cyfraKontrolna;
    }

}
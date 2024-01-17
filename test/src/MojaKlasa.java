import java.lang.reflect.Array;
import java.util.Arrays;

class MojaKlasa implements Comparable<MojaKlasa> {
    private int wartosc;

    public MojaKlasa(int wartosc) {
        this.wartosc = wartosc;
    }

    public int getWartosc() {
        return wartosc;
    }

    @Override
    public int compareTo(MojaKlasa innaKlasa){
        return Integer.compare(this.wartosc,innaKlasa.getWartosc());
    }


    public static void main(String[] args) {
        MojaKlasa[] tablica = {
                new MojaKlasa(5),
                new MojaKlasa(2),
                new MojaKlasa(8),
                new MojaKlasa(1)
        };

        // Wyświetlamy nieposortowaną tablicę
        System.out.println("Nieposortowana tablica: " + Arrays.toString(tablica));

        // Sortujemy tablicę przy użyciu metody sort z Arrays
        Arrays.sort(tablica);

        // Wyświetlamy posortowaną tablicę
        System.out.println("Posortowana tablica: " + Arrays.toString(tablica));
    }
}



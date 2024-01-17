import java.lang.reflect.Method;

public class RefleksyjneWywolanieFunkcji {
    public static void main(String[] args) throws Exception {

        Class<?> klasa = Class.forName("MojaKlasa");

        Method method = klasa.getMethod("mojaFunkcja");
        Object obiektDrugiejKlasy = (MojaKlasa) klasa.newInstance();

        method.invoke(obiektDrugiejKlasy);

    }
}


class MojaKlasa {
    public void mojaFunkcja() {
        System.out.println("Funkcja została wywołana refleksyjnie!");
    }
}
package kolos;

public class OutsideTheWorldException extends Exception {

    public OutsideTheWorldException(String s) {
        super("Pozycja jest poza granicami świata");
    }
}
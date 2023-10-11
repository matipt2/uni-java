public class Pesel {
    private String pesel;

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    public void compare(Pesel anotherPesel) {
        boolean areEqual = this.pesel.equals(anotherPesel.pesel);
        if (areEqual) {
            System.out.println("Identyczne");
        } else {
            System.out.println("Inne");
        }
    }

    public void check() {
        if (pesel.length() == 11) {
            System.out.println("Pesel jest poprawny");
        } else {
            System.out.println("Pesel jest niepoprawny");
        }
    }
}
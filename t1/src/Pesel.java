public class Pesel {
    private String pesel;
    private static int length;


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public static int getLength() {
        return length;
    }


    public Pesel(String pesel){

        this.pesel = pesel;
    }

    public static void compare(Pesel pesel1, Pesel pesel2){
        boolean areEqual = pesel1.equals(pesel2);
        if(areEqual == true){
            System.out.println("Identyczne");
        }
        else{
            System.out.println("Inne");
        }
    }

    public static void check(Pesel pesel){
        int length = pesel.length;
        if(length == 9){
            System.out.println("jest git");
        }
        else{
            System.out.println("nie jest git");
        }
    }
}

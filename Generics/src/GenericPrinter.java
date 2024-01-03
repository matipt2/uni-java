public class GenericPrinter <T>{
    T somethingToPrint;

    public GenericPrinter(T somethingToPrint){
        this.somethingToPrint = somethingToPrint;
    }

    public void print(){
        System.out.println(somethingToPrint);
    }
}

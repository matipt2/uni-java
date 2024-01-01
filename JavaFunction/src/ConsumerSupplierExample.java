import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class ConsumerSupplierExample {
    public static void main(String[] args){

        Customer someone = new Customer(12345,"someone");
        greetSomeone.accept(someone);
        System.out.println(getDBConnectionURLSupplier.get());
    }

    static Supplier<String> getDBConnectionURLSupplier = () -> "DBUrl";
    static Consumer<Customer> greetSomeone = customer ->
            System.out.println("Hello "+customer.name+" your phone number is: "+customer.number);

    static class Customer{
        private final int number;
        private final String name;

        public Customer(int number, String name) {
            this.number = number;
            this.name = name;
        }
    }
}

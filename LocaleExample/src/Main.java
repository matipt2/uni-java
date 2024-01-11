import java.util.Locale;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        Locale locale = new Locale("pl", "PL");
        Locale.setDefault(locale);
//        ResourceBundle message = ResourceBundle.getBundle("messages", locale);
//        System.out.println(message);
        String lang = locale.getLanguage();
        String country = locale.getCountry();
        System.out.println(lang+country);
        }
    }

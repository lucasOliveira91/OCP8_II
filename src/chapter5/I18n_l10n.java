package chapter5;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class I18n_l10n {
}

class Internationalization {
    public static void main(String args[]) {
        Locale us = new Locale("en", "US");
        Locale france = new Locale("fr", "FR");
        printProperties(us);
        System.out.println();
        printProperties(france);


    }

    private static void printProperties(Locale locale) {
        ResourceBundle rb = ResourceBundle.getBundle("Zoo", locale);
        System.out.println(rb.getString("hello"));
        System.out.println(rb.getString("open"));


        Properties props = new Properties();
        rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));
        System.out.println(props);
    }
}

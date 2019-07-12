package chapter5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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

class FormattingDateTime{

    public static void main(String args[]) {
        LocalDate date = LocalDate.of(2020, Month.JANUARY, 20);
        LocalTime time = LocalTime.of(11, 12, 34);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        System.out.println(dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));

        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
        System.out.println(formatter.format(dateTime));

        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("MMMM dd/MM/yyyy hh:mm");
        DateTimeFormatter customFormatter2 = DateTimeFormatter.ofPattern("dd MM yyyy");
        System.out.println(customFormatter.format(dateTime));
        LocalDate localdata2 = LocalDate.parse("10 10 2010", customFormatter2);
        System.out.println("From String: " + localdata2);

    }
}

package chapter5;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeExample {
}

class DateTimeZone {

    public static void main(String args[]) {
        System.out.println(ZonedDateTime.now());

        ZoneId zone =  ZoneId.of("US/Eastern");
        ZonedDateTime zoned = ZonedDateTime.of(LocalDate.now(), LocalTime.now(), zone);
        System.out.println(zoned);

    }
}

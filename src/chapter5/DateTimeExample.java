package chapter5;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

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

/**
 * Period
 * Can deal with data not time
 */
class PeriodExample {

    public static void main(String args[]) {
        LocalDate start = LocalDate.of(2015, Month.JANUARY, 1);
        Period period = Period.ofMonths(1);

        System.out.println(start.plus(period));
    }
}

/**
 * Duration
 * Can deal with time
 */
class DurationExample {

    public static void main(String args[]) {
        LocalDate date  = LocalDate.of(2019, 01, 10);
        LocalTime time = LocalTime.of(16, 15, 0);
        LocalDateTime dateTime = LocalDateTime.of(date, time);
        Duration duration = Duration.ofHours(20);
        dateTime = dateTime.plus(duration);
        System.out.println("modified  duration " + dateTime);

    }
}

/**
 * Instant
 * Instant is based in Zone so we is only compatible with ZoneDataTime
 * So the instant is based in GMT time
 * We can deal with day or smaller
 * Day, Hour, Minute, seconds ...
 */
class InstantExample {

    public static void main(String args[]) {
        LocalDate date  = LocalDate.of(2019, 01, 10);
        LocalTime time = LocalTime.of(16, 15, 0);
        ZoneId zone =  ZoneId.of("America/Sao_Paulo");
        ZonedDateTime zonedDateTime = ZonedDateTime.of(date, time, zone);
        System.out.println("Zone date " + zonedDateTime);
        Instant instant = zonedDateTime.toInstant();
        System.out.println("Instante date " + instant);
        instant = instant.plus(2, ChronoUnit.DAYS);
        System.out.println("Instant date modified " + ZonedDateTime.ofInstant(instant, zone));
    }
}

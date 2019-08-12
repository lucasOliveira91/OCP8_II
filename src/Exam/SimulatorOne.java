package Exam;

import javax.sound.midi.SysexMessage;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class SimulatorOne {
}

class QuestionTwo {

    //Result ue Ja
    public static void main (String[ ] args) {
        int i;
        char c;
        try (FileInputStream fis = new FileInputStream ("course.txt");
             InputStreamReader isr = new InputStreamReader(fis);) {
            while (isr.ready()) { //line n1
                isr.skip(2);
                i = isr.read ();
                c = (char) i;
                System.out.print(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

class QuestionFive {
    public static void main(String[] args) {
        StringBuilder message = new StringBuilder("hello java!");
    }
}

class QuestionEigth {
    public static void main(String[] args) {
        List<String> colors = Arrays.asList("red", "green", "yellow", "blue");
        Predicate<String> test = n -> {
            System.out.println("Searching…" + n + n.contains("red"));
            return n.contains("red");
        };
        System.out.println(colors.stream().allMatch(test));
    }
}

class QuestinEleven {
    class Address {
        String city;
    }
    public static void main(String[] args) {
        Optional<Address> addr = Optional.ofNullable(null);
        System.out.println(addr.isPresent());
    }
}

class QuestionTwoelve{
    public static void main(String[] args) {
        try (ImageScanner ir = new ImageScanner();
             ImagePrinter iw = new ImagePrinter()) {
            ir.scanImage();
            iw.printImage();
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
    }
}

class ImageScanner implements AutoCloseable {
    public void close () throws Exception {
        System.out.print ("Scanner closed.");
    }
    public void scanImage () throws Exception {
        System.out.print ("Scan.");
        throw new Exception("Unable to scan.");
    }
}

class ImagePrinter implements AutoCloseable {
    public void close () throws Exception {
        System.out.print ("Printer closed.");
    }
    public void printImage () {System.out.print("Print."); }
}


class QuestionFourteen{
    public static void main(String[] args) {
        fly( ( ) -> new Bird ( ));
        fly (Penguin :: new);

    }

    static void fly(Supplier<Bird> bird) {
        bird.get().fly();
    }
}

class Bird {
    public void fly () { System.out.print("Can fly"); }
}
class Penguin extends Bird {
    public void fly () { System.out.print("Cannot fly"); }
}

class QuestinEigthteen {
    public static void main(String[] args) {
        ZonedDateTime depart = ZonedDateTime.of(2015, 1, 15, 3, 0, 0, 0, ZoneId.of("UTC-7"));
        ZonedDateTime arrive = ZonedDateTime.of(2015, 1, 15, 9, 0, 0, 0, ZoneId.of("UTC-5"));
        System.out.println(depart);
        System.out.println(arrive);
        long hrs = ChronoUnit.HOURS.between(depart, arrive); //line n1
        System.out.println("Travel time is" + hrs + "hours");

    }
}

class QuestionNiveteen {
    public static class Product {
        int id; int price;
        public Product (int id, int price) {
            this.id = id;
            this.price = price;
        }

        public String toString() { return id + ":" + price; }
    }


    public static void main(String[] args) {
//        List<Product> products = Arrays.asList(
//                new Product(1, 10),
//                new Product (2, 30),
//                new Product (2, 30));
//        Product p = products.stream().reduce(new Product (4, 0), (p1, p2) -> {
//            p1.price+=p2.price;
//            return new Product (p1.id, p1.price);
//        });
//        products.add(p);
//        products.stream().parallel()
//                .reduce((p1, p2) -> p1.price > p2.price ? p1 : p2)
//                .ifPresent(System.out::println);

        List<String> list = Arrays.asList("Lucas", "Daniel", "Borges");
        list.stream().parallel().reduce((p1, p2) -> p1 + p2).ifPresent(System.out::println);
    }
}


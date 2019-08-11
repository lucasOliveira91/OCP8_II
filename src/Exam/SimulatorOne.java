package Exam;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

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



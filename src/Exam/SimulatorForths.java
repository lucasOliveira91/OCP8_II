package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SimulatorForths {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C://Users");
        System.out.println("Relatico" + path);
        System.out.println("Absoluto" + path.toAbsolutePath());
        Files.walk(path, 0)
                .forEach(System.out::println);

        Files.find(path, 1, (p, a) -> a.isRegularFile()).forEach(System.out::println);
    }
}

class QuestionFortyOne {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("dbURL", "userName", "passWord");
        String query = "SELECT id FROM Employee";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            stmt.executeQuery("SELECT id FROM Customer");
            while (rs.next()) {
                //process the results
                System.out.println("Employee ID: "+ rs.getInt("id"));
            }
        } catch (Exception e) {
        }
    }
}

class QuestionFortyTwo {
    public static void main(String[] args) {
        try {
            doStuff2();
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println (e.getMessage()); }
        catch (Exception e) {
            System.out.println (e.getMessage());
        }
    }

    static void  doStuff2() throws ArithmeticException, NumberFormatException, Exception {
        if (Math.random() >-1) throw new Exception ("Try again");
    }
}

class QuestionFortyThree{
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("");
        Stream<String> fc = Files.lines (path);
        fc.forEach (s -> System.out.println(s));
    }
}

class QuestionFortyFour {
    public static void main(String[] args) {
        List<Integer> list1 = Arrays.asList(10, 20);
        List<Integer> list2 = Arrays.asList(15, 30);
//        Stream.of(list1, list2).flatMap(l -> l.stream()).forEach(System.out::println);
//        IntStream ints = list1.stream().flatMapToInt(x -> IntStream.of(x));
        IntStream intStream = Stream.of(list1, list2).flatMap(x -> x.stream()).flatMapToInt(x -> IntStream.of(x));
        intStream.forEach(System.out::println);
    }
}

class QuestionFortySix{
    public static void main(String[] args) {
        LocalDate valentinesDay = LocalDate.of(2015, Month.FEBRUARY, 14);
        LocalDate nextYear = valentinesDay.plusYears(1);
        nextYear.plusDays(15); //line n1
        System.out.println(nextYear);
    }
}

class QuestionFortyEight{
    public static void main(String[] args) {
        Y myY = new Y();
        X myX = myY;
        Z myZ = myX;

        System.out.println(myX);
        System.out.println((Y) myX);
        System.out.println(myZ);
    }

    interface Z{}

    public static class X implements Z {
        public String toString() {
            return "X ";
        }
    }

    static class Y extends X {
        public String toString() {
            return "Y ";
        }
    }
}




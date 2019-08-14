package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class SimulatorTwo {
}

class QuestionsTwentyFive{
    public static void main(String[] args) {
        String color = "teal";

        switch (color) {
            case "Red":
                System.out.println("Found Red");
            case "Blue":
                System.out.println("Found Blue");
                break;
            case "Teal":
                System.out.println("Found Teal");
                break;
            default:
                System.out.println("Found Default");

        }
    }
}

class QuestionsTwentyEight{
    static class MissingInfoException extends Exception{}
    class AgeOutofRangeException extends Exception{}

    static class Cadidante{
        String name;
        int age;

        Cadidante(String name, int age) throws Exception{
            if(name == null){
                throw new MissingInfoException();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Cadidante c = new Cadidante("James", 20);
    }
}

class QuestionThrintyEight {
    interface CourseFilter extends Predicate<String> {
        public default boolean test (String str) {
            return str.equals ("Java");
        }
    }

    static List<String> strs = Arrays.asList("Java", "Java EE", "Java ME");
    static Predicate<String> cf1 = s -> s.length() > 3;
    static Predicate cf2 = new CourseFilter() { //line n1
        public boolean test (String s) {
            return s.contains ("Java");
        }
    };
    public static void main(String[] args) {
        long c = strs.stream()
                .filter(cf1)
                .filter(cf2)
                .count();
        System.out.println(c);
    }

}
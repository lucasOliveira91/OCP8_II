package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulatorFifties {
    public static void main(String[] args) {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears", "bee");
        Map<Character, List<String>> map = ohMy.collect(Collectors.groupingBy((s) -> s.charAt(0)));
//        Map<Character, Set<String>> map = ohMy.collect(
//                Collectors.groupingBy((s) -> s.charAt(0), Collectors.toSet())
//        );
        System.out.println(map); // {b=[bears], t=[tigers], l=[lions]}

//        TreeMap<Character, Set<String>> map2 = ohMy.collect(
//                Collectors.groupingBy((s) -> s.charAt(0), TreeMap::new, Collectors.toSet()));
//        System.out.println(map2); // {5=[lions, bears], 6=[tigers]}
    }
}

class QuestionFiftyOne {
    public static void main(String[] args) {
        Rideable rider = Car::new;
        System.out.println(rider.getCar("test"));
    }

    interface Rideable{
        Car getCar(String name);
    }

    static class Car{
        private String name;

        Car(String name) {
            this.name = name;
        }

        @Override
        public String toString(){
            return name;
        }
    }
}

class QuestionFiftyThree {
    public static void main(String[] args) {
        X xref = new Y();
        Y yref = (Y)xref;
        yref.mY();
        xref.mX();
        //Ym
        //Xm2
    }

    static class  X {
        public void mX() {
            System.out.println("Xm1");
        }
    }

    static class Y extends X {
        public void mX(){
            System.out.println("Xm2");
        }

        public void mY() {
            System.out.println("Ym");
        }
    }
}

class QuestionFifityFour{
    public static void main(String[] args) {
        int b = 3;
        if ( !(b > 3)) {
            System.out.println("square ");
        }

        {
            System.out.println("circle ");
        }

        System.out.println("...");
    }
}

class QuestionFifityFive {
    public static void main(String[] args) throws UserException {
        App t = new App ();
        t.doRegister("Mathew", 60);
    }

    static class UserException extends Exception { }
    static class AgeOutOfLimitException extends UserException { }

    static class App {
        public void doRegister(String name, int age) throws UserException, AgeOutOfLimitException {
            if (name.length () < 6) {
                throw new UserException ();
            } else if (age >= 60) {
                throw new AgeOutOfLimitException ();
            } else {
                System.out.println("User is registered.");
            }
        }
    }
}

class QuestionFIftyNine{
    public static void main(String[] args) {
        List<TechName> tech = Arrays.asList (
                new TechName("Java-"),
                new TechName("Oracle DB-"),
                new TechName("J2EE-")
        );
        Stream<TechName> stre = tech.stream();
        stre.map(a-> a).forEachOrdered(System.out::print);
//        stre.forEach(System.out::print);
    }

    static class TechName {
        String techName;
        TechName (String techName) {
            this.techName=techName;
        }
       public String toString() {
            return techName;
        }
    }
}


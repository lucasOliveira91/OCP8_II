package Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulatorNineties {
    public static void main(String[] args) {
        List<Student> stds = Arrays.asList(
                new Student ("Jessy", "Java ME", "Chicago"),
                new Student ("Helen", "Java EE", "Houston"),
                new Student ("Mark", "Java ME", "Chicago"));
        stds.stream()
                .collect(Collectors.groupingBy(Student::getCourse)).forEach(
                        (src, res) -> System.out.println(src));


//        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map = ohMy.collect(
//                Collectors.groupingBy(String::length, Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder())))
//        );
//        System.out.println(map); // {5=Optional[b], 6=Optional[t]}
//
    }

    static  class Student {
        String course, name, city;
        public Student (String name, String course, String city) {
            this.course = course; this.name = name; this.city = city;
        }
        public String toString() {
            return course + ":" + name + ":" + city;
        }

        String getCourse() {
            return course;
        }
    }

}

 class Customer {
    private String fName;
    private String lName;
    private static int count;
    public Customer(String first, String last) {
        fName =first;
        lName = last;
        ++count;
    }


    static { count = 0; }
    public static int getCount() {return count; }
}

 class App {
    public static void main(String[] args) {
        Customer c1 = new Customer("Larry", "Smith");
        Customer c2 = new Customer("Pedro", "Gonzales");
        Customer c3 = new Customer("Penny", "Jones");
        Customer c4 = new Customer("Lars", "Svenson");
        c4 = null;
        c3 = c2;
        System.out.println(Customer.getCount());
    }
}


class xX {
    public static void main (String[] args) throws IOException {
//        BufferedReader brCopy = null;
//        try (BufferedReader br = new BufferedReader (new FileReader("course.txt"))) { //line n1
//            br.lines().forEach(c -> System.out.println(c));
//            brCopy = br;//line n2
//        }
//        brCopy.ready(); //line n3;

//        Foo<?, ?> percentage = new Foo <> (97, 32);
//        Foo<String, String> grade = new Foo <> ("John", "A");
//        Foo<String, String> pair = Foo.<String>twice ("Hello World!");
//        Foo<String, Integer> mark = new Foo<String, Integer> ("Steve", 100);
//

        List<String> str = Arrays.asList ("my", "pen", "is", "your", "pen");
        Predicate<String> test = s -> {
            int i = 0;
            boolean result = s.contains ("pen");
            System.out.print((i++) + ":");
            return result;
        };
        str.stream()
                .filter(test)
                .findFirst()
                .ifPresent(System.out ::print);
    }


    static class Foo<K, V> {
        private K key;
        private V value;
        public Foo (K key, V value) {
            this.key = key;
            this.value = value;
        }


        public static <T> Foo<T, T> twice (T value) {
            return new Foo<T, T> (value, value);
        }
        public K getKey () {return key;}
        public V getValue () {return value;}
    }
}



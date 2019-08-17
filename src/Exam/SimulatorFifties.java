package Exam;

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

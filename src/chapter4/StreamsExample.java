package chapter4;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExample {

    public static void main(String args[]) {
        Stream<Double> randoms = Stream.generate(Math::random);

        Stream<String> s = Stream.of("monkey", "ape", "bonobo");
        Optional<String> min = s.min((s1, s2) -> s1.length() - s2.length());
        min.ifPresent(System.out::println);


        List<String> list = Arrays.asList("monkey", "2", "chimp");
        Predicate<String> pred = x -> Character.isLetter(x.charAt(0));
        System.out.println(list.stream().anyMatch(pred));

    }
}

/**
 * Collect
 * The first parameter is a supplier the there is no parameter but returns a value
 * The seconde parameter is a BiConsumer there are two parameters ex: StringBuilder, Next String
 * The final parameter is responsible to take tow data collections and merging then
 * take all before results and merge to the other collection
 */
class StreamCollect {

    public static void main(String args[]) {
        Stream<String> stream = Stream.of("l","u", "c", "a", "s");
        StringBuilder word = stream.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println(word.toString());
    }
}

/**
 * ---- Intermediate Operation -----
 * Peek
 * it usually used to debug operations without modify the currently stream
 */
class PeekExample {

    public static void main(String args[]) {
        Stream<String> stream = Stream.of("lucas", "daniel", "borges");
//        long l = stream.filter(s -> s.startsWith("l")).peek(System.out::println).count();
//        System.out.println(l);


        Stream<Integer> infinite = Stream.iterate(1, x -> x +1);
        infinite.limit(5)
                .peek(p -> System.out.println("valor" + p))
                .filter(x -> x % 2 == 1)
                .forEach(System.out::println);
    }
}

class CollectorsStreamExample {

    public static void main(String args[]) {
        Stream<String> ohMy = Stream.of("lions", "tigers", "bears");
        String result = ohMy.collect(Collectors.joining(", "));
        System.out.println(result);

        //To new Collection
        Stream<String> ohMy2 = Stream.of("lions", "tigers", "bears");
        TreeSet<String> result2 = ohMy2.filter( s -> s.startsWith("t"))
                .collect(Collectors.toCollection(TreeSet::new));
        System.out.println(result2);

        //Grouping
        Stream<String> ohMy3 = Stream.of("lions", "tigers", "bears");
        Map<Integer, List<String>> map = ohMy3.collect(Collectors.groupingBy(String::length));
        System.out.println("Grouping " + map);

        //PartitinBy
        Stream<String> ohMy4 = Stream.of("lions", "tigers", "bears");
        Map<Boolean, List<String>> map2 = ohMy4.collect(Collectors.partitioningBy(s -> s.length() <= 7));
        System.out.println("Partition " + map2);

        //Mapping
//        Stream<String> ohMy5 = Stream.of("lions", "tigers", "bears");
//        Map<Integer, Optional<Character>> map3 = ohMy5.collect(
//                Collectors.groupingBy(
//                        String::length,
//                        Collectors.mapping(s -> s.charAt(0), Collectors.minBy(Comparator.naturalOrder()))
//                ));
//        System.out.println("Mapping " + map3);

    }

}


class ExerciciesValidation {
    public static void main(String args[]) {
        Stream<String> s = Stream.generate(() -> "meow");
        boolean match = s.allMatch(String::isEmpty);
        System.out.println(match);
    }
}


package chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
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

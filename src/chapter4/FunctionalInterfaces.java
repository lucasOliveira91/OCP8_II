package chapter4;


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {



}

/**
 * Supplier
 * No Parameters
 * return the generic type
 */
class SupplierExample {
    public static void main(String args[]) {
        Supplier<LocalDate> s1 = LocalDate::now;
        LocalDate date = s1.get();

        System.out.println(date);
    }
}

/**
 * Consumer
 * one parameter
 * none return type
 *
 * BiConsumer
 * Two parameters
 * nome return type
 */
class ConsumerBiConsumerExample{
    public static void main(String args[]) {
        Consumer<String> c1 = System.out::println;

        c1.accept("Lucas");

        Map<String, Integer> map = new HashMap<>();
        BiConsumer<String, Integer> c2 = map::put;
        c2.accept("Daniel", 12);

        System.out.println(map);
    }
}

/**
 * Predicate
 * one paramaeter
 * returns a boolean
 *
 * BiPredicate
 * Two parameters
 * returns a boolean
 *
 *
 * they are often used to make filtering or matching
 *
 */
class PredicateBiPredicateExample{
    public static void main(String args[]) {
        Predicate<String> p2 = String::isEmpty;
        System.out.println(p2.test("Lucas"));

        BiPredicate<String, String> p3 = String::startsWith;
        System.out.println(p3.test("LucasD", "Lu"));

    }
}

/**
 * Function
 * two parameters, the first is the value and second is the return type
 * Can be return different value type
 *
 * BiFuncition
 * Can receive  2 parameters but always the last parameter will be the return type
 * you can create your own functions passing more parameters but the last is the return type
 */
class FunctionBiFunctionExample {
    public static void main(String args[]) {
        Function<String, Integer> f1 = String::length;
        System.out.println(f1.apply("Daniel"));

        BiFunction<String, String, String> f2 = String::concat;
        System.out.println( f2.apply("Lucas", "Daniel"));

        TriFunction<String,String, String, Integer> f3 = FunctionBiFunctionExample::example;
        System.out.println( f3.apply("Lucas", "Daniel",  "Borges"));

    }

    public static  Integer example(String s1, String s2, String s3){
        return (s1 + s2 + s3).length();
    }


    interface TriFunction<T, U, V, R> {
        R apply(T t,U u,V v);
    }
}

/**
 * UnaryOperator -- extends funcitons
 * BinaryOperator  -- extends Bifunction
 * Both the parameters must be the same type
 * It is like the functions but the parameters and return  type must be equals type
 * it doesn't need set the return value, because always the return type is the same
 */
class UnaryOperatorBinaryOperator{
    public static void main(String args[]) {
        UnaryOperator<String> u1 = String::toUpperCase;
        System.out.println(u1.apply("lucas"));

        BinaryOperator<String> b1 = String::concat;
        System.out.println(b1.apply("Lucas", "Daniel"));
    }

}



package chapter4;

import java.util.Optional;

public class OptionalExample {

    public static void main(String args[]) {
        Optional<Double> opt =  Optional.of(100d);

        System.out.println(opt.orElse(Double.NaN));
        opt.ifPresent(System.out::println);
        opt.orElseThrow(IllegalAccessError::new);
    }
}

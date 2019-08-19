package Exam;

import java.util.function.BiFunction;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class SimulatorSeventies {
    public static void main(String[] args) {
        IntStream stream = IntStream.of (1,2,3);
        IntFunction<Integer> inFu= x -> x; //line n1
//        IntStream newStream = stream.map(inFu.applyAsIn(10));
//        newStream.forEach(System.output::print);

//        BiFunction<Integer, Double, Integer> val = (t1, t2) -> t1 + t2;//line n1
//        System.out.println(val.apply(10, 10.5));

//        int num = 5;
//        int sum;
//        do {
//            sum += num;
//        }while((num--) > 1);
    }
}

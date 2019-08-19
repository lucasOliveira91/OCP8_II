package Exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import java.util.stream.Stream;

public class SimulatorSixfies {

}

class QuestionSixtwo {
    public static void main(String[] args) {
        DoInterface doi= new DoClass();
        doi.m1(100);
        doi.m2(200);
    }

    interface DoInterface {
        void m1(int n);
        public void m2(int n);
    }

    static class DoClass implements DoInterface{
        int x1,x2;
        DoClass(){
            this.x1 = 0;
            this.x2= 10;
        }
        @Override
        public void m1(int p1) {
            x1 += p1;
            System.out.println(x1);
        }

        @Override
        public void m2(int p1) {
            x2 += p1;
            System.out.println(x2);
        }
    }
}

class QuestionSistyThree{
    public static void main(String[] args) {
        List<Alpha> stra = new ArrayList<>();
        stra.add(new Alpha());
        stra.add(new Beta());
        stra.add(new Gamma());

        for (Alpha t:stra) {
            System.out.println(t.doStuff("Java"));
        }
    }

    static class Alpha{
        public String doStuff(String msg)  {
            return msg;
        }
    }

    static class Beta extends Alpha {
        public String doStuff(String msg) {
            return msg.replace('a', 'e');
        }
    }

    static class Gamma extends Beta {
        public String doStuff(String msg) {
            return msg.substring(2);
        }
    }
}

class QuestionSixtyFour{
    public static void main(String[] args) {
        Thread thread1 = new Thread(new MyThread());
        Thread thread2 = new Thread(new MyThread());
        Thread thread3 = new Thread(new MyThread());
        Thread [] ta = {thread1, thread2, thread3};
        for (int x= 0; x < 3; x++) {
            ta[x].start();
        }
    }

    static  class MyThread implements Runnable {
        private static AtomicInteger count = new AtomicInteger(0);
        public void run () {
            int x = count.incrementAndGet();
            System.out.print (x + "");
        }
    }
}

class QuestionSistySix {
    public static void main(String[] args) {
        List<String> nL = Arrays.asList("Jim", "John", "Jeff");
        Function<String, String> funVal = s -> "Hello : ".concat(s);
        nL.stream()
                .map(funVal)
                .forEach(System.out::print);
    }
}

class QuestionSixtySeven{
    public static void main(String[] args) {
    }
    public abstract class Task implements Doable {
        public void doSomethingElse(String s) { }
    }

    public class Do implements Doable {
        public void doSomething(Integer i) { }
        public void doSomething(String s) { }
        public void doThat (String s) { }
    }

    interface Doable {
        public void doSomething(String s);
    }
}

class QuestionSixtyEight{
    public static String doMsg(char x) {
        return "Good Day!";
    }

    public static String doMsg(int y) {
        return "Good Luck";
    }

    public static void main(String[] args) {
        char x = 8;
        int z = '8';

        System.out.println(doMsg(x));
        System.out.print(doMsg(z));
    }
}

class QuestionSixtySix{
    public static void main(String[] args) {
        Stream<List<String>> iStr= Stream.of (
                Arrays.asList ("1", "John"),
                Arrays.asList ("2", null));
//        Stream<String> nInSt = iStr.flatMapToInt((x) -> x.stream ());
//        nInSt.forEach (System.out :: print);
    }
}
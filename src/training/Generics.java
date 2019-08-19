package training;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Generics {
    public static void main(String[] args) {
        Grate grate = new Grate();
        grate.calculate("Lucas");
        System.out.println(grate.getValue());
        Grate.ship("String");
    }
}

interface Do<T, U> {
    U calculate(T t);
}

class Grate<T> implements Do<String, Integer>{

    @Override
    public Integer calculate(String txt) {
        return txt.length();
    }

    Integer getValue() {
        return calculate("Lucas");
    }

    public static <T> Grate<T> ship(T t) {
        System.out.println("Preparing " + t);
        return new Grate<T>();
    }
}

class LegacyAutoboxing {
    public static void main(String[] args) {
        java.util.List numbers = new java.util.ArrayList();
        numbers.add(5);
//        int result = numbers.get(0); // DOES NOT COMPILE

        Object[] number = {1,2};
        number[0] = "teste";

        Integer[] ints =  {1,2,3};
        Object[] obs = ints;
        obs[0] = 1;
        obs[1] = "XXXX";
    }
}

class Nano {
    interface Lista<T>{
        Integer[] getTotal(int tam);
    }

    static class ArrayLista<T> implements Lista<T>{
        public Integer[] getTotal(int tam) {
            return new Integer[tam];
        }
    }

    public static void main(String[] args) {
        Lista<Number> lista = new ArrayLista<>();

//        System.out.println(lista.getTotal(10).length);
        printList(Arrays.asList(1, 2.1, 2.2, 1));
    }

    public static void printList(List<? extends Number> list) {
        for (Number x: list)
            System.out.println(x.doubleValue() / 2);
    }
}

class Passaros<Animal> {
    static class Sparrow extends Bird { }
    static class Bird { }

    public static void main(String[] args) {
        List<? extends Bird> birds = new ArrayList<>();
//        birds.add(new Sparrow()); // DOES NOT COMPILE
//        birds.add(new Bird()); // DOES NOT COMPILE

//        List<HangGlider> lsit =  new ArrayList<>();
//        groupOfFlyers(lsit);
//        List< Gato> animlas = new ArrayList<>();
////        animlas.add(new Gato());
////        teste(animlas);

//        List<? super IOException> exceptions = Arrays.asList(new Exception);
//        4: exceptions.add(new Exception()); // DOES NOT COMPILE
//        5: exceptions.add(new IOException());
//        6: exceptions.add(new FileNotFoundException());

        List<? super Gato> list1 = new ArrayList<Minhador>();
//        list1.add(new Animal());
//        list1.add(new Object());
        list1.add(new Gato());
        list1.add(new Gato() {

        });

        System.out.println(method2(Arrays.asList(new Gato())));
    }

    interface Flyer { void fly(); }
    class HangGlider implements Flyer { public void fly() {} }
    class Goose implements Flyer { public void fly() {} }

    private  static void anyFlyer(List<Flyer> flyer) {}
    private static void groupOfFlyers(List<? extends Flyer> flyer) {}
    private static void teste(List<? extends Gato> a) {
       a.forEach(ax -> ax.run());
    }


    static  Integer method2(List<? super Gato> list) { // DOES NOT COMPILE
        return list.size();
    }

}

class Animal {
    public void run() {
        System.out.println("Animal generico");
    }
}

class Gato extends Animal implements Minhador{
    public void run() {
        System.out.println("Gato correndo");
    }
}
class Bichano extends Gato{
    public void run() {
        System.out.println("Bichano  correndo");
    }
}

interface Minhador{

}

class Other {
    public static void main(String[] args) {
        Crianca crianca = new Joao();
        crianca.brincar();
    }

    interface Crianca<T extends  Crianca> {
        default void hello() {
            System.out.println("Bom dia! " + getNome());
        }
        T brincar();

        String getNome();
    }

    static class Joao implements Crianca<Joao>{
        private String name = "João";

        @Override
        public Joao brincar() {
            Joao joao = new Joao();
            hello();
            System.out.println(joao.name + " está brincando.");
            TV.count(Arrays.asList(joao));
            return joao;
        }

        @Override
        public String getNome() {
            return name;
        }
    }

    static class TV<R>{
        public static void count(List<? extends Crianca> t) {
            System.out.println(t.size());
        }

        static <T> void count2(T t) {

        }

        <T extends Object> T method3(List<? extends Animal> list) {
            return null; // DOES NOT COMPILE
        }
    }
}

package chapter3;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Name Conventions for Generics
 * E for an element
 * K for a map Key
 * V for a map value
 * N for a Number
 * T for a generic data type
 * S, U, V and so forth for multiple generic types
 */
public class Generics {
    public static void main(String args[]) {
        Crate<Dog, Long> crate = new Crate<Dog, Long>(new Dog(), 1000_00L);

        List list = new ArrayList<>();
        list.add(5);

        //Does not compile because list makes the autoboxing and the inserted number are Objects
        //int  i = list.get(0);
        List<String> list1 = new ArrayList<>();
        test1(list1);

        /**
         * UNBOUNDED WILDCARD
         * Can accept any types
         */
        List<Long> list2 = new ArrayList<>();
        List<Object> list3 = new ArrayList<>();
        test2(list2);
        //Denied because the list yet Long
        //test2(list3);

        /**
         * Denied because the UPPER BOUNDED WILDCARD OR  UNBOUNDED become the list immutable
         * Whe we can say that list can accept subclasses from that
         * Use extends than implements because the Upper bounds is like anonymous classes
         */
        List<? extends Bird> birds =  new ArrayList<>();
//        birds.add(new Object());

        List<?> objects =  new ArrayList<>();
//        objects.add(new Object());

        List<? extends Child> family =  new ArrayList<>();
        // Does not work because the UPPER BOUNDED is immutable
//        family.add(new Parent());
//        family.add(new Child());
        test3(family);


        /**
         * Lower BOUND
         */
        List<? super IOException> exceptions =  new ArrayList<>();
//        exceptions.add(new Exception());
        exceptions.add(new IOException());
        exceptions.add(new FileNotFoundException());

        List<? super Bird> birds1 =  new ArrayList<>();
        birds1.add(new Sparrow());
        birds1.add(new Bird() {
            @Override
            public void teste() {

            }
        });
        List<? super Child> family2 =  new ArrayList<>();
//        family2.add(new Parent());
        family2.add(new Child());


    }

    interface Bird {
        void teste();
    }
    static class Sparrow implements Bird{
        @Override
        public void teste() {

        }
    }

    static class Parent {}
    static class Child extends Parent{}
    static void test1(List<?> list) {
        System.out.println(list);
    }

    static void testando2(List<? super IOException> list) {
        System.out.println(list);
    }

    static void test2(List<? extends Number> list) {
        System.out.println(list);
    }

    static void test3(List<? extends Parent> list) {
        System.out.println(list);
    }
}

class Dog {}

class Crate<T, U> {
    private T content;
    private U sizeLimit;

    public Crate(T content, U sizeLimit) {
        this.sizeLimit = sizeLimit;
        this.content = content;
    }

    public T emptyCrate() {
        return content;
    }

    public void packCrate(T content) {
        this.content = content;
    }

     void sink(T t) {

    }

     public static <T> T noGood() {
        return null;
     }
}

interface Shippable<T> {
    void ship(T i);

    static <T, U> Crate<T, U> ship() {
        return null;
    }


}

class Robot{}

class ShippableRobotCrate implements Shippable<Robot>{

    @Override
    public void ship(Robot i) {

    }


}

class ShippableAbstractCrate<T> implements Shippable<T> {

    @Override
    public void ship(T i) {

    }
}

class ShippableCrate implements Shippable {

    @Override
    public void ship(Object i) {

    }
}
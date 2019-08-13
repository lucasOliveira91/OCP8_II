package chapter1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemException;
import java.util.ArrayList;
import java.util.List;

/**
 * IntanceOf Rule
 * Check if the class is a type direct or indirect
 */
public class InstanceOf {

    static interface Mammal{}

    static class Furry implements Mammal {}
    static class Chipmuk extends Furry{}



    public static void main(String args[]) {

        HeavyAnimal heavyAnimal = new Hippo();
        System.out.println(heavyAnimal instanceof Hippo); //True
        System.out.println(heavyAnimal instanceof HeavyAnimal); //true
        System.out.println(heavyAnimal instanceof Elephant); //False

        Chipmuk c = new Chipmuk();
        Mammal m = c;
        ArrayList<Chipmuk> l = new ArrayList<>();

        /**
         * Does not compile because arraylsit is a concrete class
         */
//        System.out.println(l instanceof Chipmuk);

    }

    public void feedAnimal(HeavyAnimal animal){

        if(animal instanceof Hippo) {
            ((Hippo) animal).seed();
        }
    }

}

class HeavyAnimal{

}

class Hippo extends HeavyAnimal{

    public void seed() {

    }
}

class Elephant extends HeavyAnimal{

}

class ExampleTip {
    interface Animal {}
    static abstract class Feline implements Animal{}
    static class Cat extends Feline implements Animal{}
    static class Dog implements Animal {}

    public static void main(String[] args) {
        Animal animal = new Cat();
        Feline feline = new Cat();

        System.out.println(animal instanceof Animal); //True - its super class is Animal
        System.out.println(animal instanceof Feline); //True - super class Feline has Animal as interface
        System.out.println(animal instanceof Dog); //false - Dog implements Animal , but the object is Animal that has Cat as instance
        System.out.println(feline instanceof Animal); //true
    }
}
interface Animal{
    Animal run() throws IOException;
}
class ExampleTip2 {


    class HeavyAnimal implements Animal{
        @Override
        public HeavyAnimal run() throws FileNotFoundException {
            System.out.println("Running sloly...");
            return null;
        }
    }

    class Dog extends HeavyAnimal {
        @Override
        public HeavyAnimal run() {
            System.out.println("Running sloly when it is full...");
            return null;
        }

        private void run(String x) throws FileSystemException{

        }
    }

    public static void main(String[] args) {

    }
}
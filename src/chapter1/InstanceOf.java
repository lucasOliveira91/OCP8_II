package chapter1;

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


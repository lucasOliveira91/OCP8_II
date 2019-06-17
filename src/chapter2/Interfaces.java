package chapter2;

/**
 *  ----- Interfaces Definition -----
 */
public class Interfaces {
}

/**
 * The Functional Interface
 * It must have only an abstract method
 * The annotation is not required
 * they are used in the lambda expressions in funcional programming
 */
@FunctionalInterface
interface FuntionalInterfaceExemplo {

    void run();
}


class Animal {
    private String species;
    private boolean canHop;
    private boolean canSwin;

    public Animal(String speciesName, boolean hopper, boolean swimmer) {
        this.species = speciesName;
        this.canHop = hopper;
        this.canSwin = swimmer;
    }

    public boolean canHop() {
        return canHop;
    }

    public boolean canSwin() {
        return canSwin;
    }

    public String toString() {
        return species;
    }
}

interface CheckTrait{
    boolean test(Animal a);
}

interface Predicate<T>{
    boolean test(T a);
}

class FindMatchAnimals{
    private static void print(Animal animal, CheckTrait trait) {
        if(trait.test(animal)) {
            System.out.println(animal);
        }
    }

    private static void print2(Animal animal, Predicate<Animal> trait) {
        if(trait.test(animal)) {
            System.out.println(animal);
        }
    }

    /**
     * The lambda expression it if were an implementation of the test from the ChackTrait interface
     * The value passed should be the same the return value type from the interface method
     * @param args
     */
    public static void main(String args[]) {
        Animal fish = new Animal("fish", true, true);
        Animal dog = new Animal("dog", true, true);
        print(fish, a -> a.canHop());
        print2(dog, a -> a.canHop());
    }
}
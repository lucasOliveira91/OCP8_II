package chapter1;

/**
 * IntanceOf Rule
 * Check if the class is a type direct or indirect
 */
public class InstanceOf {

    public static void main(String args[]) {

        HeavyAnimal heavyAnimal = new Hippo();
        System.out.println(heavyAnimal instanceof Hippo); //True
        System.out.println(heavyAnimal instanceof HeavyAnimal); //true
        System.out.println(heavyAnimal instanceof Elephant); //False
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

package chapter3;

import java.util.*;
import java.util.Collections;

public class Comparation {

    public static void main(String args[]) {
        Set<Pet> list = new TreeSet<>();
        list.add(new Pet(3, "Bartô", 2));
        list.add(new Pet(2,"Leleco", 2));
        list.add(new Pet(5,"Anzain", 3));
        list.add(new Pet(1,"Chalie", 3));

       System.out.println(list);

        List<Pet> list2 =  new ArrayList<>();
        list2.add(new Pet(3, "Bartô", 1));
        list2.add(new Pet(2,"Leleco", 2));
        list2.add(new Pet(5,"Anzain",3));
        list2.add(new Pet(1,"Chalie", 4));
        Collections.sort(list2);
        System.out.println(list2);

        Collections.sort(list2, (d1, d2) -> d1.weight - d2.weight);
    }
}

class Pet implements Comparable<Pet>{
    int id;
    String name;
    int  weight;

    public Pet(int id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pet o) {
        return this.name.compareTo(o.name);
    }
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Pet)){
            return false;
        }

        Pet pet = (Pet) o;
        return this.id == pet.id;
    }
}

package chapter2;

import java.security.Principal;

public class Polimorfism {
}

class Primate{
    public boolean hasHair() {
        return true;
    }
}

interface HasTail{
    boolean isTailStriped();
}

class Lemur extends Primate implements HasTail{

    public int age = 10;

    @Override
    public boolean isTailStriped() {
        return false;
    }

    public static void main(String args[]) {
        Lemur lemur =  new Lemur();
        System.out.println(lemur.age);

        HasTail hasTail = lemur;
        System.out.println(hasTail.isTailStriped());

        Primate primate = lemur;
        System.out.println(primate.hasHair());

        Lemur l = new Lemur();
        l = (Lemur) primate;

        //Throws ClassCastException in runntime
        //Because it is not Object from the Lemur type
        Primate p = new Primate();
        Lemur ll =  (Lemur) p;
    }
}

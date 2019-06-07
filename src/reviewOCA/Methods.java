package reviewOCA;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectStreamException;

/**
 *  Overriding and Overload
 */
public class Methods extends Classes implements Animal{


    public static void main(String args[]) {

        Classes animal = new Methods();
        animal.seedAnimal();

        /**
         * Child Class doen't receive a parent Class
         */
//        Methods m = new Classes();
    }

    @Override
    public final void seedAnimal() {
        System.out.println("Seeding  animal from METHOD!!!");
    }

    @Override
    public void run() {

    }
}

class Classes {
    public void seedAnimal() {
        System.out.println("Seeding defaut animal!!!");
    }

}

interface Animal {
    void run();
}

class BobCat {

    protected void findDen() {

    }

    protected void findCen() throws FileNotFoundException {

    }

    void findCen2() throws IOException {

    }

    public void withCovarients(Integer num1) {

    }

    public Methods withCovarients2() {
        return null;
    }

    public Classes withCovarients3() {
        return null;
    }
}


/**
 * ----Overrriding Rules----
 * Main Rule -  it has the same name, return type and number of parameters
 * 1. The access modifier must be the same or more accessible.
 * 2. The return type must be the same or more restrictive , also known as 'convarient return types'
 * 3. If any checked Exceptions are throw, only the same exceptions or subclasses of those exceptions
 *
 * >>>> THE METHODS MUST NOT BE STATIC - in this case they are hidden and not overridden.
 */
class BobCatKitten extends BobCat {

    /**
     *  This method is being overriding
     *  Because it has the same name, return type and number of parameters
     */
    public void findDen()  {

    }

    /**
     * In this case the throw Exception is parent , it ins't suported
     * @throws IOException
     */
    protected void findCen() {//throws IOException {

    }

    /**
     * It's not necessary declare the throws Exceptions
     * and the modifier is more acessible
     */
    public void findCen2() {

    }

    /**
     * This case IS NOT a Overridden
     * Because the parameter is not the same
     * @param num1
     */
    public void withCovarients(Number num1) {

    }

    /**
     * This case the return type is a parent class IS NOT allowed to overriddem
     * @return
     */
    public Methods withCovarients2() {
        return null;
//        return new Classes();
    }

    /**
     * Correct way return covariates
     * @return
     */
    public Classes withCovarients3() {
        return new Methods();
    }
}

/**
 * -------Overload Rules -------
 * Overload is when the methods have the same name but the return type, parameters are differents
 */
class BobPuppy extends BobCat {

    /**
     * Overload method
     *
     * @param s1
     */
    public void findDen(String s1) {

    }

    /**
     * The return type should be the exactly the same or type of
     * This case IS NOT a case because the return type is completely different
     * @return
     */
//    public String findDen() {
//
//    }

    /**
     * Return with same type
     *
     * @param p1
     * @return
     */
    public Classes withCovarients2(String p1) {
        return null;
    }

    /**
     * More Parameter is allowed
     * @param p1
     * @param p2
     * @return
     */
    public Classes withCovarients2(String p1, String p2) {
        return null;
    }

    /**
     * it can throw any Exceptions
     * @param p1
     * @throws ObjectStreamException
     */
    public void findCen2(long p1) throws ObjectStreamException {

    }

}

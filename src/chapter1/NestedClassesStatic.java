package chapter1;

/**
 * ----- Static Inner Class ------
 *  It can use any access modifier
 *  The enclosing class can refer to the fields an methods of the static nested class.
 *  To import the static inner class is neeed to use import static
 */
public class NestedClassesStatic {
        private int price1 = 6;

    private static class Nested{
        private int price = 6 ; // it neeed the instance enclosing class+ price1;
    }

    class Inner{
        private int price = 6 + price1;
    }

    public static void main(String args[]) {
        Nested nested = new Nested();
        System.out.println(nested.price);
    }
}

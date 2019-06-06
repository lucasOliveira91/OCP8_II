package chapter1;

/**
 * ------ Local Inner Classes Rules ------
 * They don't have an access modifier
 * Can't be static or to have any static methods or variables
 * Can have access to all field and methods of the enclosing class
 * They don't have access to local variables of a method unless those variables are final or effectively final
 */
public class NestedClassesLocal {

    private int length = 5;

    public void calcule() {
        final int width = 20;

        class Inner{
            public void multiply() {
                System.out.println(length * width);
            }
        }

        Inner inner = new Inner();
        inner.multiply();
    }

    public static void main(String args[]) {
        NestedClassesLocal outer =  new NestedClassesLocal();
        outer.calcule();
    }



}

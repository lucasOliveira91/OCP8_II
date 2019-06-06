package chapter1;

/**
 * -----Nested Classes Rules ----
 * It is defined within another class
 * The one is not static is called INNER CLASS
 *
 * MEMBER INNER CLASS
 * -It is defined  at the same leval as instance variables, it should not static
 * LOCAL INNER CLASS
 * -It is defined within the method
 * ANONYMOUS
 * -It is the same than local class but in this case i doesn't have name.
 * STATIC CLASS (NESTED CLASS)
 * -That is defined at the same leval as satatic variables
 */
public class NestedClassesMember {

    private String greeting = "HI";
    private int x = 10;

    /**
     * INNER CLASS
     * - Can be declared public, private,protected or default access
     * - Can extend any classes and implements interfaces
     * - Can be abstract or final
     * - Can be access members of the outer class including PRIVATE members
     */
    private class InnerClasseOne {
        public int repeat = 3;
        private int x = 20;

        public void go() {
            for (int i =0; i< repeat; i++){
                System.out.println(greeting);
            }
        }


        class InnerClasseTwo{
            private int x = 30;

            public void allTheX() {
                System.out.println(x); // 30
                System.out.println(this.x); // 30
                System.out.println(InnerClasseOne.this.x); // 20
            }
        }
    }

    /**
     * The interface can be private and refereced for any inner classes
     */
    private interface Secret {
        void shh();
    }

    class DontTell implements Secret{

        @Override
        public void shh() {

        }
    }

    public void callInner() {
        InnerClasseOne inner = new InnerClasseOne();
        inner.go();
    }

    public static void main(String args[]) {
        NestedClassesMember outer = new NestedClassesMember();
        outer.callInner();

        InnerClasseOne innerClasseOne = outer.new InnerClasseOne();
        innerClasseOne.go();

        InnerClasseOne.InnerClasseTwo innerClasseTwo = innerClasseOne.new InnerClasseTwo();
        innerClasseTwo.allTheX();

        /**
         * It doesn't work, because the java needs to know which instance of outer can be used.
         */
//        InnerClasseOne teste = new InnerClasseOne();
    }
}

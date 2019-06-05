package reviewOCA;

/**
 * ---- Abstract Classes -----
 * 1. it can have methods without body signing as abstract
 * 2. It can have concrete methods
 */
public class AbstractClasses {
}


abstract class Cat{
    abstract void clean();
     void clean(String p1){}
}

class Lion extends Cat{
    void clean(){

    }

    void clean(String p1, Long l1){

    }
}


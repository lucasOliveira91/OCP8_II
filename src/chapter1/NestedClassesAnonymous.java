package chapter1;

/**
 * ----- Annonymous Inner Classes Rules -------
 * Same rules the Local Inner Classes
 * Pay attention when extends a class or implements an interface
 * in both cases is used new operator when it is instantiate
 * Can't implements and extends in the same time.
 * it can be pass as parameter as well
 */
public class NestedClassesAnonymous {

    abstract class SaleTodayonlu{
        abstract int dollarsOff();
    }

    public int admisssion(int basePrince) {
        SaleTodayonlu sale = new SaleTodayonlu() {
            @Override
            //If it were a interface , this method would be public
            int dollarsOff() {
                return 3;
            }
        }; // Semicolon is necessary

        return basePrince - sale.dollarsOff();
    }
}

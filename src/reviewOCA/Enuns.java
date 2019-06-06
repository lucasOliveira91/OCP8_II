package reviewOCA;

/**
 * ------- Enuns Rules ------
 * When the toString is called, it's printed the enum name
 * The comparation between enuns can be done using == or equals
 * Enuns can`t be extended
 * When it be switch comparation you should campare with values only, the statment like SEASON.SPRING It DOES COMPILe
 * some case when is numbers
 */
public class Enuns {

    public static void main(String args[]) {
        Season season = Season.SPRING;
        System.out.println(season.toString()); // SPRING
        System.out.println(season.equals(Season.SPRING)); //true
        System.out.println(season == Season.SPRING); //true
//        System.out.println(season == 3); Enuns shouldn't be compare with numbes, but object are allowed
//        System.out.println(season == Long.parseLong("1"));


        switch (season) {
//            case  Season.WINTER: Does Not compile
//                System.out.println("Get out the sled");
//                break;
//            case  0: Does Not compile
//                System.out.println("Get out the sled");
//                break;
            case  WINTER:
                System.out.println("Get out the sled");
                break;
            case SUMMMER:
                System.out.println("Time for the pool");
                break;
            default:
                System.out.println("Is it summer yet?");
        }


        Season2 p1 = Season2.FALL;
        Season2 p2 = Season2.SUMMMER;
    }
}

enum Season {
    WINTER, SPRING, SUMMMER, FALL
}

/**
 * Case there are thing bisdes the values de semicolon(;) is required
 * The construicto should NOT be PUBLIC - because it should be call within the enum
 * The construictor is called once for each value
 */
enum Season2 {
    WINTER("Low"), SPRING("Medium"), SUMMMER("High"), FALL("Mediam");

    private String expectedVisitors;
    private Season2(String expectedVisitors) {
        System.out.println("Construing" + expectedVisitors);
        this.expectedVisitors = expectedVisitors;
    }

    public void printExpectedVisitors() {
        System.out.println(expectedVisitors);
    }
}


/**
 * Enum with abstract method
 * When the enum has abstract methods, each value should implement that method
 */
enum Season3 {
    WINTER{
        @Override
        public void printHours() {
            System.out.println("9am - 3pm");
        }
    }, SPRING{
        @Override
        public void printHours() {

        }
    }, SUMMMER{
        @Override
        public void printHours() {

        }
    }, FALL{
        @Override
        public void printHours() {

        }

        public void print2() {

        }
    };

    public abstract void printHours();

    void print2() {
        System.out.println("Defaut print.");
    }
}





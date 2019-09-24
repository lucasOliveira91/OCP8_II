import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ForTests {

    static void doStuff() throws ArithmeticException, NumberFormatException, Exception {
        if (Math.random() >-1) throw new Exception ("Try again");
    }

    public static void main(String[] args) {
        try {
            doStuff ();
        } catch (ArithmeticException | NumberFormatException e) {
            System.out.println (e.getMessage()); }
        catch (Exception e) {
            System.out.println (e.getMessage()); }
    }

}




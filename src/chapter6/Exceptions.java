package chapter6;

import java.io.IOException;
import java.util.Scanner;

public class Exceptions {

}


class trycatch {

    public static void main(String args[]) {
        try(Scanner scanner = new Scanner(System.in)) {
            scanner.nextLine();
        }catch (RuntimeException ex) {

        }
//
//        try {
//            Scanner scanner = new Scanner(System.in);
//        }catch (IOException | ClassNotFoundException ex) {
//
//        }
    }
}

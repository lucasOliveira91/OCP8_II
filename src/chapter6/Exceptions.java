package chapter6;

import java.io.IOException;
import java.sql.SQLException;
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

    public void read () throws SQLException {
        throw new SQLException();
    }
}

class autoCloseExample implements AutoCloseable {

    @Override
    public void close() throws Exception {
    }

    public static void main(String args[]) {
        try( autoCloseExample autoCloseExample = new autoCloseExample()){

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

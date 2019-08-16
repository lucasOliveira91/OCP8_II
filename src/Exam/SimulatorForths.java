package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.*;

public class SimulatorForths {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C://Users");
        System.out.println("Relatico" + path);
        System.out.println("Absoluto" + path.toAbsolutePath());
        Files.walk(path, 0)
                .forEach(System.out::println);

        Files.find(path, 1, (p, a) -> a.isRegularFile()).forEach(System.out::println);
    }
}

class QuestionFortyOne {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection("dbURL", "userName", "passWord");
        String query = "SELECT id FROM Employee";
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            stmt.executeQuery("SELECT id FROM Customer");
            while (rs.next()) {
                //process the results
                System.out.println("Employee ID: "+ rs.getInt("id"));
            }
        } catch (Exception e) {
        }
    }

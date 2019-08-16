package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

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

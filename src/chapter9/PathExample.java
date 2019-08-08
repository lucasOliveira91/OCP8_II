package chapter9;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("C:\\teste\\teste1\\teste2");
        System.out.println(path.subpath(1,3).getName(1).toAbsolutePath());
        System.out.println(path.toAbsolutePath());

        Files.walk(path).filter((p) -> p.isAbsolute());
    }
}

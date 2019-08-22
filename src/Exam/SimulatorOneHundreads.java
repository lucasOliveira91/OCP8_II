package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static jdk.nashorn.internal.runtime.regexp.joni.Syntax.Java;

public class SimulatorOneHundreads {
}

class QuestionTwelve {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream<Path> listOfFiles = Files.walk(Paths.get("Java Projects"));
        listOfFiles.forEach(line -> {
            executor.execute(new FileThread(line.getFileName().toString())); //

        });
        executor.shutdown();
        executor.awaitTermination(5, TimeUnit.DAYS);//

    }
}

 class FileThread implements Runnable {
    String fName;
    public FileThread(String fName) { this.fName = fName; }
    public void run (){ System.out.println(fName);}
}
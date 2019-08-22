package Exam;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SimulatorOneHundreads {
}

class QuestionTwelve {
    public static void main(String[] args) throws IOException, InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        Stream<Path> listOfFiles = Files.walk(Paths.get("C://uploads"));
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
     public void run (){
         for (int i = 0; i < 100; i++) {
             System.out.println("Executando arquivo : " + fName);
         }
     }
 }

 class QuestionThrteen {
    interface Contract {}
    static class Super implements Contract{};
    static class Sub extends Super{}
     public static void main(String[] args) {
        List obj = new ArrayList();

        Contract c1 = new Super();
        Contract c2 = new Sub();
        Super s1 = new Sub();

        obj.add(c1);
        obj.add(c2);
        obj.add(s1);

         for (Object o : obj) {
             System.out.println(o.getClass().getName());
         }
     }
 }

 class QuestionOneHundreadFourteen {
     public static void main(String[] args) {
         int rateOfInterest = 0;
         String accountType = "LOAN";
         switch (accountType) {
             case "RD":
                 rateOfInterest = 5;
                 break;
             case "FD":
                 rateOfInterest = 10;
                 break;
             default:
                 assert false : "No interest for this account"; //line n1
         }
         System.out.println("Rate of interest:" + rateOfInterest);
     }
 }

 class QuestionOneHundredFifiteen {
     public static void main(String[] args) {
         List<String> codes = Arrays.asList ("DOC", "MPEG", "JPEG");
         codes.forEach (c -> System.out.print(c + " "));
         String fmt = codes.stream()
                 .filter (s-> s.contains ("PEG"))
                 .reduce((s, t) -> s + t).orElse(null);
         System.out.println("\n" + fmt);

         //DOC MPEG JPEG
         //MPEGJPEG
     }
 }

 class QuestionOneHundredSeventeen {
     public static void main(String[] args) {
         List<Emp>li = Arrays.asList(new Emp("Sam", 20), new Emp("John", 60), new Emp("Jim", 51));
         Predicate<Emp> agVal = s -> s.getEAge() > 50;//line n1
         li = li.stream().filter(agVal).collect(Collectors.toList());
         Stream<String> names = li.stream().map(Emp::getEName);//line n2
         names.forEach(n -> System.out.print(n + " "));
     }
 }

 class Emp{
        private String eName;
        private Integer eAge;
        Emp (String eN, Integer eA) {
            this.eName = eN;
            this.eAge = eA;
        }
        public Integer getEAge () {return eAge;}
        public String getEName () {return eName;}
}
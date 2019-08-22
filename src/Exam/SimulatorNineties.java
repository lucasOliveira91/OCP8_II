package Exam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.*;


public class SimulatorNineties {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = null;
       try{
           es = Executors.newFixedThreadPool(4); //line n1
           Future f1 = es.submit (new CallerThread("Call"));
           Future f2 = es.submit (new CallerThread("Callzim"));
           String str = f1.get().toString();
           System.out.println(str);

           while (!f1.isDone() || !f2.isDone()) {
               System.out.println("Processing!!");
           }
       }finally {
           es.shutdown();
       }
    }
}

 class CallerThread implements Callable<String> {
    String str;
    public CallerThread(String s) {this.str=s;}
    public String call() {
        for (int i = 0; i < 100000 ; i++) {
            System.out.println(i);
        }
        return str.concat("Call");
    }
}

class QuestionNinetySeven {
    public static void main(String[] args) throws IOException {
        BufferedReader brCopy = null;
        try (BufferedReader br = new BufferedReader (new FileReader("course.txt"))) { //line n1
            br.lines().forEach(c -> System.out.println(c));
            brCopy = br;//line n2
        }
        brCopy.ready(); //line n3;
    }
}



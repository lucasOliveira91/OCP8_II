package chapter7;

import java.util.concurrent.*;

public class ThreadsExample {
}

class RunnableAndCallable {

    public static void main(String[] args) {
        Runnable task1 = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Task One " + i);
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Task Two" + i);
            }
        };

        Callable task3  = () -> {
            for (int i = 0; i < 50; i++) {
                System.out.println("Task Three " + i);
            }
            return "Done";
        };

        System.out.println("Processors: " + Runtime.getRuntime().availableProcessors());
        ExecutorService service = null;
       try {
           service = Executors.newFixedThreadPool(4);
           Future<?> f1 = service.submit(task1);
           service.submit(task2);
           service.submit(task3);

       }finally {
        service.shutdown();
       }

    }
}

class ScheduledThreads{

    public static void main(String[] args) {
        ScheduledExecutorService service = null;
        try {
            service = Executors.newSingleThreadScheduledExecutor();

            Runnable task1 = () -> {
                for(int i = 0; i < 50; i++)
                    System.out.println("Executing 1 " + i);
            };

               Runnable task2 = () -> {
                for(int i = 0; i < 50; i++)
                    System.out.println("Executing 2 " + i);
            };

            service.scheduleAtFixedRate(task1, 0, 2, TimeUnit.MILLISECONDS);
            service.scheduleAtFixedRate(task2, 0, 2, TimeUnit.MILLISECONDS);


        }finally {
//            service.shutdown();
        }
    }
}

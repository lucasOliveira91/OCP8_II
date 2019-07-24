package chapter7;

import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConcurrencySolutions {

    public static void main(String[] args) {
        Queue<String> q = new ConcurrentLinkedQueue<>();
        q.offer("A");
        q.offer("B");
        q.add("C");

        for (String item :q) {
            q.poll();

            System.out.println(item);
        }

        for (String item :q) {
            System.out.println(item);
        }

    }
}

/**
 * Create a new structure from the set every time the date is modified
 */
class CopyOnWrite {

    public static void main(String[] args) {
        List<Integer> l =  new CopyOnWriteArrayList();
        l.add(1);
        l.add(2);

        for (Integer i: l) {
            l.remove(new Integer(1));
        }

        System.out.println(l.size());
    }
}


class BlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        BlockingDeque<String> queue = new LinkedBlockingDeque<>();
        Thread.sleep(2000000);
        queue.offer("A",1, TimeUnit.MINUTES);
        queue.offer("B");
        queue.offer("C");
        queue.add("D");

        for (String item: queue) {
            System.out.println(item);
        }
    }
}

class Reduce {

    public static void main(String[] args) {
        Stream<String> stream = Arrays.asList("L","U","C","A","S").parallelStream();

        String reduce = stream.reduce("", String::concat);
        System.out.println(reduce);

        Stream<String> stream2 = Arrays.asList("L","U","C","A","S").parallelStream();
        List<String> list = stream2.collect(Collectors.toList());
        System.out.println(list);

    }
}

class ForkJoinFramework {

    static class WeighAnimalAction extends RecursiveAction{

        private int start;
        private int end;
        private Double[] weights;

        public WeighAnimalAction(Double[] weights, int start, int end ){
            this.weights = weights;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if(end - start <= 3) {
                for (int i = start; i < end; i++) {
                    weights[i] = (double) new Random().nextInt(100);
                    System.out.println("Animal weighed: " + i);
                }
            }else {
                int middle = start + ((end-start) / 2);
                System.out.println("[start="+start+",middle=" + middle + ", end=" +end + "]");
                invokeAll(new WeighAnimalAction(weights, start, end),
                          new WeighAnimalAction(weights, start, end)
                );
            }
        }
    }

    public static void main(String[] args) {
        Double[] weights = new Double[10];
        ForkJoinTask<?> task = new WeighAnimalAction(weights,0, weights.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);

        System.out.println();
        System.out.print("Weights: ");
        Arrays.asList(weights).stream().forEach(
                d -> System.out.print(d.intValue()+" "));
    }
}

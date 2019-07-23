package chapter7;

import java.util.List;
import java.util.Queue;
import java.util.concurrent.*;

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

package chapter3;


import java.util.*;

/**
 * Collecton main interfaces
 * List, SET, QUEUE
 *
 * SET - Other interface but is considered like collection
 */
public class Collections {

    public static void main(String args[]) {

        /**
         * The LinkedList is the same the list but it can insert e remove data from end and final of list
         */
        List<String> linked =  new LinkedList();
        linked.add("One");
        linked.add("TWO");
        linked.add("THREE");

        System.out.println(linked);

        ((LinkedList<String>) linked).addFirst("Zero");
        System.out.println(linked);
    }
}

/**
 * TreeSet uses the natual order or comparable order so the treeset is ordered
 * And it implements the NavigableSet and can navigate within the set
 */
class Seting{
    public static void main(String args[]) {
        Set<Integer> setting = new TreeSet();
        setting.add(10);
        setting.add(1);
        setting.add(5);
        setting.add(8);
        setting.add(4);

        System.out.println(setting);
        System.out.println(((TreeSet<Integer>) setting).lower(4));
        System.out.println(((TreeSet<Integer>) setting).headSet(8));

        TreeSet<String> setting2 = new TreeSet();
        setting2.add("One");
        setting2.add("ONE");

        System.out.println(setting2.ceiling("ONExx"));


    }
}

/**
 * Queue can be line or stack
 * FIFO or LIFO
 * ** offer adds on the end
 * ** peek return the next element
 * ** remove  and returns the next element
 * ** push put the element to the front of the queue
 */
class QueueExample {

    public static void main(String args[]) {
        /**
         * --------- Queue -------------
         */
        System.out.println("Adding file. ");
        Queue<Integer> queue = new ArrayDeque();
        queue.offer(10); // adding in the end
        queue.offer(5); // adding in the end
        queue.offer(8); // adding in the end
        System.out.println(queue);

        //Next value from the line
        System.out.println("Calling next");
        System.out.println(queue.peek());

        System.out.println("Finishing treatment...");
        System.out.println(queue.poll());

        System.out.println(queue);


        /**
         * --------- Stack -------------
         */
        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
        System.out.println("Adding to stack ");
        stack.push(10);
        stack.push(15);
        stack.push(1);
        System.out.println(stack);
        stack.poll();
        System.out.println(stack);

    }
}

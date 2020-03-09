package queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueImpl {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        queue.add("Nick");
        queue.add("Kevin");
        queue.add("Joe");
        for(String s: queue){
            System.out.println(s);
        }
        System.out.println(queue.element()); //FIFO
        System.out.println(queue.size());
        System.out.println(queue.remove());
        System.out.println(queue.size());
        for(String s: queue){
            System.out.println(s);
        }
    }
}

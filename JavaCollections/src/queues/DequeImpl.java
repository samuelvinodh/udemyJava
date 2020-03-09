package queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeImpl {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offerFirst(10);
        deque.offerLast(20);
        deque.offerFirst(30);
        deque.offerLast(40);
        for(Integer i: deque){
            System.out.println(i);
        }
        deque.removeFirst();
        System.out.println(deque.size());
        System.out.println(deque.getFirst());
        System.out.println(deque.removeLast());
    }
}

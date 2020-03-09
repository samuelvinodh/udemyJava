package queues;

import util.Person;

import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueImpl {
    public static void main(String[] args) {
        Queue<Person> queue = new PriorityQueue<>();
        queue.add(new Person("Kevin",22));
        queue.add(new Person("Nick",19));
        queue.add(new Person("Joe",28));
        queue.add(new Person("Sophia",20));
        while(queue.peek() != null){
            System.out.println(queue.poll());
        }
        System.out.println(queue.size());
    }
}

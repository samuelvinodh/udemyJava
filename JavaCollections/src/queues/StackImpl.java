package queues;

import java.util.Stack;

public class StackImpl {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        System.out.println(stack.peek()); //LIFO
        System.out.println(stack.size());
        System.out.println(stack.pop());
        System.out.println(stack.size());
        for(Integer i: stack){
            System.out.println(i);
        }
    }
}

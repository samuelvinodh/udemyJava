package lists;

import java.util.LinkedList;
import java.util.List;

public class LinkedListImpl {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(3);
        list.add(10);
        list.add(20);
        list.remove(0);//Removal at head/tail is faster
        //list.get(1);
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        for(Integer i: list){
            System.out.println(i);
        }
    }
}

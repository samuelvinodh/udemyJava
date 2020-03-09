package sets;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetImpl {
    public static void main(String[] args) {
        //O(logN) for add(), remove(), contains() + Natural order
        Set<Integer> set = new TreeSet<>();
        set.add(2);
        set.add(10);
        set.add(4);
        set.add(-3);
        for(Integer i: set){
            System.out.println(i);
        }
    }
}

package sets;

import java.util.LinkedHashSet;
import java.util.Set;

public class LinkedHashSetImpl {
    public static void main(String[] args) {
        Set<Integer> set = new LinkedHashSet<>();
        // O(1) for add(), remove(), contains() + Insertion order
        set.add(1);
        set.add(3);
        set.add(5);
        set.add(2);
        for(Integer i: set){
            System.out.println(i);
        }
        set.remove(2);
    }
}

package sets;

import java.util.HashSet;
import java.util.Set;

public class HashSetImpl {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>(); //HashMap underlying, no order guaranteed
        set.add("Adam");
        set.add("Joe");
        set.add("Nick");
        set.add("Adam");
        System.out.println(set.contains("Adam"));
        System.out.println(set.contains("Kevin"));
        System.out.println(set.size());
        for(String s: set){
            System.out.println(s);
        }
    }
}

package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortingII {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(5);
        list.add(0);
        list.add(-2);
        list.add(1);
        Collections.sort(list); //same way for String
        System.out.println(list);
    }
}

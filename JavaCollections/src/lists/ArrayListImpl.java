package lists;

import java.util.List;
import java.util.ArrayList;

public class ArrayListImpl {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Adam");
        list.add("Joe");
        list.add("Kevin");
        //list.remove(0);
        System.out.println(list.get(1)); //Random access
        System.out.println(list.size());
        //System.out.println(list.toArray());
        for(String s: list){
            System.out.println(s);
        }
        Object[] array = list.toArray();
        for(Object o: array){
            System.out.println(o);
        }
    }
}

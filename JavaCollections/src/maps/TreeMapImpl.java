package maps;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapImpl {
    public static void main(String[] args) {
        // O(logN) for get(), put(), remove() + Natural sorting order
        Map<String, Integer> map = new TreeMap<>();
        map.put("Nick",21);
        map.put("Joe",28);
        map.put("Sophia",24);
        map.put("Ana",22);
        for(String s: map.keySet()){
            System.out.println(s);
        }
    }
}

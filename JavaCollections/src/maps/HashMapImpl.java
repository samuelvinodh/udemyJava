package maps;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(); //No order guaranteed
        // not synchronized + one null key allowed, any null values (HashTable: Synchronized, no null keys/values)
        map.put("Adam",23);
        map.put("Kevin",33);
        map.put("Anna",20);
        System.out.println(map.get("Adam"));
        System.out.println(map.get("Nick"));
    }
}

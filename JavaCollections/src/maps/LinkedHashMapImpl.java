package maps;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapImpl {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<>(); //Insertion Order
        map.put("a",1);
        map.put("b",2);
        map.put("c",3);
        map.put("e",5);
        map.put("d",4);
        for(Map.Entry<String,Integer> entry: map.entrySet()){
            System.out.println(entry.getKey()+"-"+entry.getValue());
        }
    }
}

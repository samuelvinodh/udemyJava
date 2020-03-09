package lists;

import java.util.List;
import java.util.Vector;

public class VectorImpl {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>(10,5); //Synchronized
        vector.add(10);
        vector.add(20);
        vector.add(30);
        vector.add(40);
        vector.remove(0);
        for(Integer i: vector){
            System.out.println(i);
        }
    }
}

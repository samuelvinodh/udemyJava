import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsLowerBound {

    public static void show(List<? super Number> list){
        for(Object o: list){
            System.out.println(o);
        }
    }
    public static void main(String[] args) {
        List<Serializable> list = new ArrayList<>();
        list.add("Vinodh");
        list.add("Anu");
        show(list);
    }
}

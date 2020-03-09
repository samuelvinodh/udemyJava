import java.util.ArrayList;
import java.util.List;

class Bucket<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }
}
public class TypeInference {

    public static <T> void addStore(T t, List<Bucket<T>> list){
        Bucket<T> tBucket = new Bucket<>();
        tBucket.setItem(t);
        list.add(tBucket);
        System.out.println(t.toString()+" is added to the List");
    }

    public static void main(String[] args) {
        List<Bucket<String>> bucketList = new ArrayList<>();
        TypeInference.addStore("Adam", bucketList);
        //TypeInference.<String>addStore("Justin",bucketList);
    }
}

class HashTable<K,V>{
    private K key;
    private V value;

    public HashTable(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString() {
        return key.toString()+"-"+value.toString();
    }
}
public class GenericsMultiple {
    public static void main(String[] args) {
        HashTable<String, Integer> hashTable = new HashTable<>("Hello World!",33);
        System.out.println(hashTable);
    }
}

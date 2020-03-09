class Store<T>{
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    @Override
    public String toString() {
        return ""+this.item.toString();
    }
}

public class Generic2 {
    public static void main(String[] args) {
        Store<String> stringStore = new Store<>();
        stringStore.setItem("Hello World!");
        String item = stringStore.getItem();
        System.out.println(stringStore);
    }
}

class GM{
    public <T> void showItem(T t){
        System.out.println("The item is: "+t.toString());
    }
    public <T> T getItem(T t){
        return t;
    }
    public <T> void showArray(T[] array){
        for(T item: array){
            System.out.print(item.toString()+" ");
        }
    }
}
public class GenericMethod {
    public static void main(String[] args) {
        GM gm = new GM();
        gm.showItem("Hello World!");
        System.out.println("Integer item: "+gm.getItem(33));
        System.out.println("String item: "+gm.getItem("Hello!"));
        Integer[] integers = {3,4,5,6};
        gm.showArray(integers);
        String[] strings = {"Kevin","Joe","Adam","Justin"};
        gm.showArray(strings);
    }
}

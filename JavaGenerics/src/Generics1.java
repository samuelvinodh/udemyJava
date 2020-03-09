public class Generics1 {

    public static void addint(int num1, int num2){
        System.out.println("Sum is: "+ (num1+num2));
    }
    public static void adddouble(double num1, double num2){
        System.out.println("Sum is: "+ (num1+num2));
    }
    public static <T extends Number> void add(T num1, T num2){
        if(num1 instanceof Integer && num2 instanceof Integer){
            System.out.println("Sum (Generic) is: "+ (num1.intValue()+num2.intValue()));
        } else if (num1 instanceof Double || num2 instanceof Double){
            System.out.println("Sum (Generic) is: "+ (num1.doubleValue()+num2.doubleValue()));
        }
    }
    public static void main(String[] args) {
        addint(1,2);
        adddouble(1.5,2);
        add(1,2);
        add(1.5,2);
    }
}

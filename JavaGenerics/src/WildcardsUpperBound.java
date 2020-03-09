import java.util.Arrays;
import java.util.List;

public class WildcardsUpperBound {
    public static double sum(List<? extends Number> list){
        double sum = 0.0;
        for(Number n : list){
            sum += n.doubleValue();
        }
        System.out.println("Sum is: "+sum);
        return sum;
    }
    public static void main(String[] args) {
        sum(Arrays.asList(1,2,3,4));
        sum(Arrays.asList(1.1,2.3,3.4,4.5));
    }
}

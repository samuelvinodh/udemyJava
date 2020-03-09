import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Wildcards {

    public static void print(Collection<? extends Shape> shapeCollection){
        for(Object o : shapeCollection){
            System.out.println(o);
        }
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        print(circleList);
    }
}

interface Shape{
    public void draw();
}

class Circle implements Shape{

    @Override
    public void draw() {

    }
}

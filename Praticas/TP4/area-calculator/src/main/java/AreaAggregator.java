import java.util.ArrayList;
import java.util.List;

public class AreaAggregator implements SumProvider{
    private List<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    @Override
    public double sum() {
        double sum = 0;
        for (Shape shape: shapes) {
            sum += shape.getArea();
        }
        return sum;
    }
}

package shape.shapes;
import shape.Shape;
import java.util.Objects;

public class Line extends Shape {
    private int x2;
    private int y2;

    public Line(int x1, int y1, int x2, int y2) {
        super(x1, y1);
        this.x2 = x2;
        this.y2 = y2;
    }


    @Override
    public double perimeter() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    @Override
    public double square() {
        return 0;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x1 += deltaX;
        y1 += deltaY;
        x2 += deltaX;
        y2 += deltaY;
    }

    @Override
    public void fill(String color) {
        System.out.println("Линии не могут быть заполнены цветом");
    }

    @Override
    public String toString() {
        return "Линия: x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Line o) {
            return x1 == o.x1 && y1 == o.y1 && x2 == o.x2 && y2 == o.y2 && Objects.equals(color, o.color);
        }
        return false;
    }


    public int[] getCoords() {
        return new int[]{x1, y1, x2, y2};
    }

    public void setCoords(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
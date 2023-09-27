package shape.shapes;
import shape.Shape;
import java.util.Objects;

public class Circle extends Shape {
    private int radius;

    public Circle(int x1, int y1, int radius) {
        super(x1, y1);
        this.radius = radius;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double square() {
        return Math.PI * radius * radius;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x1 += deltaX;
        y1 += deltaY;
    }

    @Override
    public void fill(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Circle: x = " + x1 + ", y = " + y1 + ", radius = " + radius;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Circle o) {
            return x1 == o.x1 && y1 == o.y1 && radius == o.radius && Objects.equals(color, o.color);
        }
        return false;
    }


    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
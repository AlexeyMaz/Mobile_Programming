package shape.shapes;
import shape.Shape;
import java.util.Objects;

public class Triangle extends Shape {
    private int side1;
    private int side2;
    private int side3;

    public Triangle(int x1, int y1, int side1, int side2, int side3) {
        super(x1, y1);
        setSides(side1, side2, side3);
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double square() {
        double p = perimeter() / 2.0;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
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
        return "Triangle: x = " + x1 + ", y = " + y1 + ", side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Triangle o) {
            return x1 == o.x1 && y1 == o.y1 && side1 == o.side1 && side2 == o.side2 && side3 == o.side3 && Objects.equals(color, o.color);
        }
        return false;
    }

    public int[] getSides() {
        return new int[] {side1, side2, side3};
    }
    public void setSides(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
}
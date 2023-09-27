package shape.shapes;
import shape.Shape;
import java.util.Objects;

public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(int x1, int y1, int width, int height) {
        super(x1, y1);
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    
    @Override
    public double square() {
        return width * height;
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
        return "Rectangle: x = " + x1 + ", y = " + y1 + ", width = " + width + ", height = " + height;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Rectangle o) {
            return x1 == o.x1 && y1 == o.y1 && width == o.width && height == o.height && Objects.equals(color, o.color);
        }
        return false;
    }


    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
}
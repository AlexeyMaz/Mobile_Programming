package shape.shapes;

import shape.interfaces.Drawable;
import shape.interfaces.GeometricObject;
import shape.interfaces.Movable;

import java.util.Objects;

public class Circle implements GeometricObject, Movable, Drawable {
    private int x;
    private int y;
    private int radius;
    private String color;

    public Circle(int x, int y, int radius) {
        setCoords(x, y);
        this.radius = radius;
        this.color = "white";
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double getSquare() {
        return Math.PI * radius * radius;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "Circle: x = " + x + ", y = " + y + ", radius = " + radius;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Circle o) {
            return x == o.x && y == o.y && radius == o.radius && Objects.equals(color, o.color);
        }
        return false;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован круг");
    }

    @Override
    public void fill(String color) {
        this.color = color;
    }

    public int[] getCoords() {
        return new int[] {x, y};
    }
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {this.color = color;}
}
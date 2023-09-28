package shape.shapes;

import shape.interfaces.Drawable;
import shape.interfaces.GeometricObject;
import shape.interfaces.Movable;

import java.util.Objects;

public class Rectangle implements GeometricObject, Movable, Drawable {
    private int x;
    private int y;
    private int width;
    private int height;
    private String color;

    public Rectangle(int x, int y, int width, int height) {
        setCoords(x, y);
        this.width = width;
        this.height = height;
        this.color = "white";
    }


    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public double getSquare() {
        return width * height;
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "Rectangle: x = " + x + ", y = " + y + ", width = " + width + ", height = " + height;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Rectangle o) {
            return x == o.x && y == o.y && width == o.width && height == o.height && Objects.equals(color, o.color);
        }
        return false;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован прямоугольник");
    }

    @Override
    public void fill(String color) {
        this.color = color;
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

    public int[] getCoords() {
        return new int[] {x, y};
    }
    public void setCoords(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {this.color = color;}
}
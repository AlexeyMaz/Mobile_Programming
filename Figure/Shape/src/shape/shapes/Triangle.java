package shape.shapes;

import shape.interfaces.Drawable;
import shape.interfaces.GeometricObject;
import shape.interfaces.Movable;

import java.util.Objects;

public class Triangle implements GeometricObject, Movable, Drawable {
    private int x;
    private int y;
    private int side1;
    private int side2;
    private int side3;
    private String color;

    public Triangle(int x, int y, int side1, int side2, int side3) {
        setCoords(x, y);
        setSides(side1, side2, side3);
        this.color = "white";
    }

    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    @Override
    public double getSquare() {
        double p = getPerimeter() / 2.0;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public void move(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    @Override
    public String toString() {
        return "Triangle: x = " + x + ", y = " + y + ", side1 = " + side1 + ", side2 = " + side2 + ", side3 = " + side3;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Triangle o) {
            return x == o.x && y == o.y && side1 == o.side1 && side2 == o.side2 && side3 == o.side3 && Objects.equals(color, o.color);
        }
        return false;
    }

    @Override
    public void draw() {
        System.out.println("Нарисован треугольник");
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

    public int[] getSides() {
        return new int[] {side1, side2, side3};
    }
    public void setSides(int side1, int side2, int side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {this.color = color;}
}
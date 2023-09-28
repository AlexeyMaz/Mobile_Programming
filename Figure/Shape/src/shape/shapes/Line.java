package shape.shapes;

import shape.interfaces.Drawable;
import shape.interfaces.GeometricObject;
import shape.interfaces.Movable;


public class Line implements GeometricObject, Movable, Drawable {
    private int x1;
    private int y1;
    private int x2;
    private int y2;


    public Line(int x1, int y1, int x2, int y2) {
        setCoords(x1, y1, x2, y2);
    }


    @Override
    public double getPerimeter() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }


    @Override
    public double getSquare() {
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
    public String toString() {
        return "Линия: x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Line o) {
            return x1 == o.x1 && y1 == o.y1 && x2 == o.x2 && y2 == o.y2;
        }
        return false;
    }

    @Override
    public void draw() {
        System.out.println("Нарисована линия");
    }

    @Override
    public void fill(String color) {
        System.out.println("Линии не могут быть заполнены цветом");
    }

    public int[] getCoords() {
        return new int[] {x1, y1, x2, y2};
    }
    public void setCoords(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
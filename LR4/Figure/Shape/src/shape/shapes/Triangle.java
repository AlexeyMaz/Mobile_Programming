package shape.shapes;

import shape.Shape;
import java.awt.*;

public class Triangle extends Shape {
    private int x2, y2, x3, y3;

    public Triangle(int x1, int y1, int x2, int y2, int x3, int y3, Color color) {
        super(x1, y1, color);
        setCoords(x1, y1, x2, y2, x3, y3);
    }

    @Override
    public String toString() {
        return "Triangle: x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2 +
                "x3 = " + x3 + ", y3 = " + y3;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object))
            if (object instanceof Triangle o) {
                return x2 == o.x2 && y2 == o.y2 && x3 == o.x3 && y3 == o.y3;
            }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        int[] xPoints = {x1, x2, x3};
        int[] yPoints = {y1, y2, y3};
        g.fillPolygon(xPoints, yPoints, 3);
    }

    public int[] getCoords() {
        return new int[] {x1, y1, x2, y2, x3, y3};
    }
    public void setCoords(int x1, int y1, int x2, int y2, int x3, int y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }
}
package shape.shapes;

import shape.Shape;
import java.awt.*;

public class Circle extends Shape {
    private int radius;

    public Circle(int x1, int y1, int radius, Color color) {
        super(x1, y1, color);
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle: x1 = " + x1 + ", y1 = " + y1 + ", radius = " + radius;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object))
            if (object instanceof Circle o) {
                return radius == o.radius;
            }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x1 - radius, y1 - radius, 2 * radius, 2 * radius);
    }

    public int getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;
    }
}
package shape.shapes;

import shape.Shape;
import java.awt.*;

public class Line extends Shape {
    private int x2, y2;

    public Line(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, color);
        setCoords(x1, y1, x2, y2);
    }

    @Override
    public String toString() {
        return "Линия: x1 = " + x1 + ", y1 = " + y1 + ", x2 = " + x2 + ", y2 = " + y2;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object))
            if (object instanceof Line o) {
                return x2 == o.x2 && y2 == o.y2;
            }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.drawLine(x1, y1, x2, y2);
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
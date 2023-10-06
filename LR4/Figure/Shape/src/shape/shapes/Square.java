package shape.shapes;

import shape.Shape;
import java.awt.*;

public class Square extends Shape {
    private int sideLength;

    public Square(int x1, int y1, int sideLength, Color color) {
        super(x1, y1, color);
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        return "Rectangle: x1 = " + x1 + ", y1 = " + y1 + ", sideLength = " + sideLength;
    }

    @Override
    public boolean equals(Object object) {
        if (super.equals(object))
            if (object instanceof Square o) {
                return sideLength == o.sideLength;
            }
        return false;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x1 - sideLength / 2, y1 - sideLength / 2, sideLength, sideLength);
    }

    public int getSideLength() {
        return sideLength;
    }
    public void setSideLength(int sideLength) {
        this.sideLength = sideLength;
    }
}
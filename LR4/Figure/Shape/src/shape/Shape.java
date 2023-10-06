package shape;

import shape.interfaces.IDrawFigure;
import java.awt.*;
import java.util.Objects;

public abstract class Shape implements IDrawFigure {
    protected int x1;
    protected int y1;
    protected Color color;

    public Shape(int x1, int y1, Color color) {
        setCoords(x1, y1);
        this.color = color;
    }

    public abstract void draw(Graphics g);

    public abstract String toString();
    public boolean equals(Object object) {
        if (object instanceof Shape o) {
            return x1 == o.x1 && y1 == o.y1 && Objects.equals(color, o.color);
        }
        return false;
    }

    public int[] getCoords() {
        return new int[]{x1, y1};
    }
    public void setCoords(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}
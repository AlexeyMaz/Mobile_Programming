package shape;

public abstract class Shape {
    protected int x1;
    protected int y1;
    protected String color;

    public Shape(int x1, int y1) {
        setCoords(x1, y1);
        this.color = "white";
    }

    public abstract double perimeter();
    public abstract double square();

    public abstract void move(int deltaX, int deltaY);
    public abstract void fill(String color);

    public abstract String toString();
    public abstract boolean equals(Object object);

    public int[] getCoords() {
        return new int[] {x1, y1};
    }
    public void setCoords(int x1, int y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {this.color = color;}
}
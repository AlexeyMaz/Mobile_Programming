package shape;

import shape.shapes.*;

public class Main {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[15];
        shapes[0] = new Line(0, 0, 3, 3);
        shapes[1] = new Rectangle(10, 10, 20, 30);
        shapes[2] = new Circle(40, 40, 15);
        shapes[3] = new Triangle(60, 60, 10, 15, 20);
        shapes[4] = new Circle(0, 10, 5);

        shapes[5] = new Circle(40, 40, 15);
        shapes[6] = new Rectangle(10, 10, 20, 30);
        shapes[7] = new Triangle(60, 60, 10, 15, 20);
        shapes[8] = new Line(0, 0, 5, 5);
        shapes[9] = new Line(0, 0, 5, 5);

        shapes[10] = new Rectangle(10, 10, 20, 30);
        shapes[11] = new Rectangle(10, 9, 10, 30);
        shapes[12] = new Circle(100, 0, 1);
        shapes[13] = new Line(1, 1, 2, 2);
        shapes[14] = new Triangle(5, 5, 10, 10, 10);

        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.println("Периметр: " + shape.perimeter());
            System.out.println("Площадь: " + shape.square());
            System.out.println("Цвет заливки: " + shape.color);
            shape.fill("blue");
            shape.move(2, 3);
            System.out.println("\n");
        }

        System.out.println(shapes[8].equals(shapes[9]));
    }
}
package shape;

import shape.shapes.*;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(10, 10, 20, 30);
        Rectangle r2 = new Rectangle(10, 10, 20, 30);


        System.out.println(r1);
        System.out.println("Периметр: " + r1.getPerimeter());
        System.out.println("Площадь: " + r1.getSquare());
        System.out.println("Цвет заливки: " + r1.getColor());
        r1.fill("blue");
        r1.move(2, 3);
        System.out.println(Arrays.toString(r1.getCoords()));
        System.out.println();


        System.out.println(r1.equals(r2));
    }
}
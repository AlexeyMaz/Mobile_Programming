package calc;

public class Calc {

    public static void main(String[] args) {
        Calculator calc = new Calculator();

        System.out.println("5+10+2 = " + calc.sum(5, 10, 2));
        System.out.println("9-3-4-2 = " + calc.sub(9, 5, 4, 2));
        System.out.println("3*2*4 = " + calc.mult(3, 2, 4));
        System.out.println("3*2*4 = " + calc.mult(3, 2, 4));
//        System.out.println("6/2=" + calc.divide(12, 3, 2));

    }
}
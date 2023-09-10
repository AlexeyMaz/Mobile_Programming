package calc;
import calc.operation.Adder;
import calc.operation.Substractor;
import calc.operation.Multiplier;
import calc.operation.Divider;
import calc.operation.Shifter;

public class Calculator {
    public int sum(int... a) {
        Adder adder = new Adder();
        for (int i : a) {
            adder.add(i);
        }
        return adder.getSum();
    }

    public int sub(int... a) {
        Substractor substractor = new Substractor(a);
        for (int i = 1; i < a.length; i++) {
            substractor.substract(a[i]);
        }
        return substractor.getSubstr();
    }

    public int mult(int... a) {
        Multiplier multiplier = new Multiplier();
        for (int i : a) {
            multiplier.multiple(i);
        }
        return multiplier.getMult();
    }
    public double divide(int... a) {
        Divider divider = new Divider(a);
        for (int i = 1; i < a.length; i++) {
            divider.split(a[i]);
        }
        return divider.getDiv();
    }
    public double shift(int... a) {
        Shifter shifter = new Shifter(a);
        for (int i = 1; i < a.length; i++) {
            shifter.to_shift(a[i]);
        }
        return shifter.getShiftRes();
    }
}
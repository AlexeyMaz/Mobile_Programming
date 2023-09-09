package calc.operation;

public class Shifter {
    private int res;

    public Shifter() {
        res = 1;
    }

    public Shifter(int... a) {
        this.res = a[0];
    }

    public void to_shift(int b) {
        res >>= b;
    }

    public double getShiftRes() {
        return res;
    }
}
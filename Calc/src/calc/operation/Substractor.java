package calc.operation;

public class Substractor {
    private int substr;

    public Substractor() {
        substr = 0;
    }

    public Substractor(int... a) {
        this.substr = a[0];
    }

    public void substract(int b) {
        substr -= b;
    }

    public int getSubstr() {
        return substr;
    }
}
package calc.operation;

public class Multiplier {
    private int mult;

    public Multiplier() {
        mult = 1;
    }

    public Multiplier(int a) {
        this.mult = a;
    }

    public void multiple(int b) {
        mult *= b;
    }

    public int getMult() {
        return mult;
    }
}
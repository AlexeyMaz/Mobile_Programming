package calc.operation;

public class Divider {
    private int divid;

    public Divider() {
        divid = 1;
    }

    public Divider(int a) {
        this.divid = a;
    }

    public void divide(int b) {
        divid /= b;
    }

    public int getDivid() {
        return divid;
    }
}
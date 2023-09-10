package calc.operation;

public class Divider {
    private int div;

    public Divider() {
        div = 0;
    }

    public Divider(int... a) {
        this.div = a[0];
    }

    public void split(int b) {
        div /= b;
    }

    public int getDiv() {
        return div;
    }
}
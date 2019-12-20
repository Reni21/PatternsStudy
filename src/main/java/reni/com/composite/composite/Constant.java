package reni.com.composite.composite;

public class Constant implements MathExpression {
    private double value;

    public Constant(double value) {
        this.value = value;
    }

    @Override
    public double calculate() {
        return value;
    }
}

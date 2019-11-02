package reni.com.task01.composite;

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

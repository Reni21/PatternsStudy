package reni.com.composite.composite;

public class Addition extends BinaryMathExpression {
    public Addition(MathExpression left, MathExpression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return super.getLeft().calculate() + super.getRight().calculate();
    }
}

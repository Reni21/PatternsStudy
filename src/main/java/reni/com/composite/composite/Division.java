package reni.com.composite.composite;

public class Division extends BinaryMathExpression {
    public Division(MathExpression left, MathExpression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return super.getLeft().calculate() / super.getRight().calculate();
    }
}

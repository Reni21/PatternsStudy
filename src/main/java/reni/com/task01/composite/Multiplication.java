package reni.com.task01.composite;

public class Multiplication extends BinaryMathExpression {
    public Multiplication(MathExpression left, MathExpression right) {
        super(left, right);
    }

    @Override
    public double calculate() {
        return super.getLeft().calculate() * super.getRight().calculate();
    }
}

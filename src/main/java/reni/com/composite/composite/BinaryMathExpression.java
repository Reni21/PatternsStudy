package reni.com.composite.composite;

public abstract class BinaryMathExpression implements MathExpression {
    private MathExpression left;
    private MathExpression right;

    public BinaryMathExpression(MathExpression left, MathExpression right) {
        this.left = left;
        this.right = right;
    }

    MathExpression getLeft() {
        return left;
    }

    MathExpression getRight() {
        return right;
    }
}

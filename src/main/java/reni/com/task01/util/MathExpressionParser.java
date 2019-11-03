package reni.com.task01.util;

import reni.com.task01.composite.*;

import java.util.ArrayList;
import java.util.List;


public class MathExpressionParser {

    public static MathExpression parseExpression(String mathExpression) {
        List<String> tokensInRpnOrder = ReversePolishNotation.createRpnFromStringsTokens(mathExpression);
        return buildExpressionsTree(tokensInRpnOrder);
    }

    private static MathExpression buildExpressionsTree(List<String> tokensInRpnOrder) {
        List<MathExpression> accumulatedResult = new ArrayList<>();
        for (String token : tokensInRpnOrder) {
            switch (token) {
                case "-":
                case "+":
                case "*":
                case "/":
                    MathExpression left = accumulatedResult.get(accumulatedResult.size() - 2);
                    MathExpression right = accumulatedResult.get(accumulatedResult.size() - 1);
                    MathExpression result = buildExpression(left, right, token);

                    accumulatedResult.remove(accumulatedResult.size() - 1);
                    accumulatedResult.remove(accumulatedResult.size() - 1);
                    accumulatedResult.add(result);
                    break;
                default:
                    accumulatedResult.add(new Constant(Double.parseDouble(token)));
            }
        }
        return accumulatedResult.get(0);
    }

    private static MathExpression buildExpression(MathExpression left, MathExpression right, String operator) {
        switch (operator) {
            case "-":
                return new Subtraction(left, right);
            case "+":
                return new Addition(left, right);
            case "*":
                return new Multiplication(left, right);
            case "/":
                return new Division(left, right);
            default:
                throw new IllegalArgumentException("Unknown operator: " + operator);
        }
    }

}

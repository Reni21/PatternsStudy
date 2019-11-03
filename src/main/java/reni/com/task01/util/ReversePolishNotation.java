package reni.com.task01.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ReversePolishNotation {
    private static final String EXTRACT_SINGLE_TOKENS_REGEX = "(?<=[-+*/()])|(?=[-+*/()])";

    public static List<String> createRpnFromStringsTokens(String mathExpression) {
        String[] tokens = mathExpression.split(EXTRACT_SINGLE_TOKENS_REGEX);

        List<String> operatorsBuff = new ArrayList<>();
        List<String> tokensInRpnOrder = new ArrayList<>();

        Arrays.stream(tokens).forEach(token -> putTokenIntoCorrectPlace(token, operatorsBuff, tokensInRpnOrder));

        int border = operatorsBuff.size();
        IntStream.range(0, border)
                .map(i -> border - i - 1)
                .forEach(i -> transferTokenFromBuff(tokensInRpnOrder, operatorsBuff, i));
        return tokensInRpnOrder;
    }

    private static void putTokenIntoCorrectPlace(String token, List<String> operatorsBuff, List<String> tokensInRpnOrder) {
        int lastOperatorIndex = operatorsBuff.size() - 1;
        switch (token) {
            case "(":
                operatorsBuff.add(token);
                break;
            case ")":
                while (!"(".equals(operatorsBuff.get(lastOperatorIndex))) {
                    transferTokenFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                    lastOperatorIndex--;
                }
                operatorsBuff.remove(lastOperatorIndex);
                break;
            case "+":
            case "-":
                if (lastOperatorIndex >= 0) {
                    String lastOperator = operatorsBuff.get(lastOperatorIndex);
                    if ("-".equals(lastOperator) || "+".equals(lastOperator)) {
                        transferTokenFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                        operatorsBuff.add(token);
                    } else {
                        putTokenIntoCorrectPlaceHelper(token, operatorsBuff, tokensInRpnOrder);
                    }
                } else {
                    operatorsBuff.add(token);
                }
                break;
            case "*":
            case "/":
                putTokenIntoCorrectPlaceHelper(token, operatorsBuff, tokensInRpnOrder);
                break;
            default:
                tokensInRpnOrder.add(token);
        }
    }

    private static void putTokenIntoCorrectPlaceHelper(String token, List<String> operatorsBuff, List<String> tokensInRpnOrder) {
        int lastOperatorIndex = operatorsBuff.size() - 1;
        if (lastOperatorIndex >= 0) {
            String lastOperator = operatorsBuff.get(lastOperatorIndex);

            if ("*".equals(lastOperator) || "/".equals(lastOperator)) {
                transferTokenFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                operatorsBuff.add(token);
            } else {
                operatorsBuff.add(token);
            }
        } else {
            operatorsBuff.add(token);
        }
    }

    private static void transferTokenFromBuff(List<String> tokensInRpnOrder,
                                              List<String> operatorsBuff, int lastTokenIndex) {
        tokensInRpnOrder.add(operatorsBuff.get(lastTokenIndex));
        operatorsBuff.remove(lastTokenIndex);
    }
}

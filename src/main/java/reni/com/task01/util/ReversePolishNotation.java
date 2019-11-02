package reni.com.task01.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ReversePolishNotation {
    private static final String EXTRACT_SINGLE_ELEMENTS_REGEX = "(?<=[-+*/()])|(?=[-+*/()])";

    public static ArrayList<String> createRpnFromStringsTokens(String mathExpression) {
        String[] tokens = mathExpression.split(EXTRACT_SINGLE_ELEMENTS_REGEX);

        ArrayList<String> operatorsBuff = new ArrayList<>();
        ArrayList<String> tokensInRpnOrder = new ArrayList<>();

        Arrays.stream(tokens).forEach(token -> putTokenIntoCorrectPlace(token, operatorsBuff, tokensInRpnOrder));

        int border = operatorsBuff.size();
        IntStream.range(0, border)
                .map(i -> border - i - 1)
                .forEach(i -> transferTokensFromBuff(tokensInRpnOrder, operatorsBuff, i));
        return tokensInRpnOrder;
    }

    private static void putTokenIntoCorrectPlace(String token, ArrayList<String> operatorsBuff, ArrayList<String> tokensInRpnOrder) {
        int lastOperatorIndex = operatorsBuff.size() - 1;
        switch (token) {
            case "(":
                operatorsBuff.add(token);
                break;
            case ")":
                while (!"(".equals(operatorsBuff.get(lastOperatorIndex))) {
                    transferTokensFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                    lastOperatorIndex--;
                }
                operatorsBuff.remove(lastOperatorIndex);
                break;
            case "+":
            case "-":
                if (lastOperatorIndex >= 0) {
                    String lastOperator = operatorsBuff.get(lastOperatorIndex);
                    if ("-".equals(lastOperator) || "+".equals(lastOperator)) {
                        transferTokensFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                        operatorsBuff.add(token);
                    } else {
                        findPlaceForOperator(token, operatorsBuff, tokensInRpnOrder);
                    }
                } else {
                    operatorsBuff.add(token);
                }
                break;
            case "*":
            case "/":
                    findPlaceForOperator(token, operatorsBuff, tokensInRpnOrder);
                break;
            default:
                tokensInRpnOrder.add(token);
        }
    }

    private static void findPlaceForOperator(String token, ArrayList<String> operatorsBuff, ArrayList<String> tokensInRpnOrder) {
        int lastOperatorIndex = operatorsBuff.size() - 1;
        if (lastOperatorIndex >= 0) {
            String lastOperator = operatorsBuff.get(lastOperatorIndex);

            if ("*".equals(lastOperator) || "/".equals(lastOperator)) {
                transferTokensFromBuff(tokensInRpnOrder, operatorsBuff, lastOperatorIndex);
                operatorsBuff.add(token);
            } else {
                operatorsBuff.add(token);
            }
        } else {
            operatorsBuff.add(token);
        }
    }

    private static void transferTokensFromBuff(ArrayList<String> tokensInRpnOrder,
                                               ArrayList<String> operatorsBuff, int lastTokenIndex) {
        tokensInRpnOrder.add(operatorsBuff.get(lastTokenIndex));
        operatorsBuff.remove(lastTokenIndex);
    }
}

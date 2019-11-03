package reni.com.task01;

import reni.com.task01.composite.MathExpression;
import reni.com.task01.util.MathExpressionParser;

import java.util.Scanner;

public class CalculatorApp {

    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(System.in)) {
            new CalculatorApp().runDemoCalculatorApp(scanner);
        }
    }

    private void runDemoCalculatorApp(Scanner scanner){
        System.out.println("INPUT FORMAT: \n > use just positive numbers \n > use symbols: +, -, *, /, () \n");
        String msg = "Enter math expression for calculation:";

        while (true) {
            try {
                System.out.println(msg);
                String input = scanner.nextLine(); // = (1+2)*4+5*(3+6)
                MathExpression expression = MathExpressionParser.parseExpression(input);
                double result = expression.calculate(); // = 57.0
                System.out.println(input + "=" + result);
                System.out.println();
            } catch (Exception e) {
                System.out.println("Something went wrong. Try once more...");
            }
        }
    }
}

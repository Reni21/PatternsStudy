package reni.com.factorymethod;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.factory.*;

import java.util.*;

public class TetrisApp {
    private static final List<FigureFactory> FIGURE_FACTORIES_CATALOG = new ArrayList<>();

    static {
        FIGURE_FACTORIES_CATALOG.add(new SuperFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new SquareFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new LineFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new TFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new LFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new LFlippedFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new ZFigureFactory());
        FIGURE_FACTORIES_CATALOG.add(new ZFlippedFigureFactory());
    }

    public static void main(String[] args) {
        new TetrisApp().runTetrisApp();
    }

    private void runTetrisApp() {
        System.out.println("Enter a digit to set the numbers of loop iterations.");

        String input = null;
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
            int numberOfLoopIterations = Integer.parseInt(input);
            Random random = new Random();

            int numberOfFactories = FIGURE_FACTORIES_CATALOG.size();
            for (int i = 0; i < numberOfLoopIterations; i++) {
                System.out.format("Number %d - ", i + 1);
                FigureFactory factory = FIGURE_FACTORIES_CATALOG.get(random.nextInt(numberOfFactories));
                Figure figure = factory.createFigure();
                System.out.println(figure.getClass().getSimpleName());
                System.out.println(figure + "\n");
            }

        } catch (NumberFormatException e) {
            System.out.format("Incorrect number format %s.", input);
        }
    }
}

package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.SquareFigure;

public class SquareFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new SquareFigure();
    }
}

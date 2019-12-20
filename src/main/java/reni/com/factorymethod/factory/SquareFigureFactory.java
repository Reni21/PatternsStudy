package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.SquareFigure;

public class SquareFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new SquareFigure();
    }
}

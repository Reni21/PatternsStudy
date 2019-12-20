package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.LineFigure;

public class LineFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LineFigure();
    }
}

package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.LFlippedFigure;

public class LFlippedFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LFlippedFigure();
    }
}

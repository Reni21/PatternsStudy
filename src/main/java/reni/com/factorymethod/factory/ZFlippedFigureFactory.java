package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.ZFlippedFigure;

public class ZFlippedFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new ZFlippedFigure();
    }
}

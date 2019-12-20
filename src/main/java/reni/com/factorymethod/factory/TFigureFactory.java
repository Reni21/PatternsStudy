package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.TFigure;

public class TFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new TFigure();
    }
}

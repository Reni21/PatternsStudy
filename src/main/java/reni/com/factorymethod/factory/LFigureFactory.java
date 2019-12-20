package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.LFigure;

public class LFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LFigure();
    }
}

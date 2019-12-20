package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.ZFigure;

public class ZFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new ZFigure();
    }
}

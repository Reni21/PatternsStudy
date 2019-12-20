package reni.com.factorymethod.factory;

import reni.com.factorymethod.entity.Figure;
import reni.com.factorymethod.entity.SuperFigure;

public class SuperFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new SuperFigure();
    }
}

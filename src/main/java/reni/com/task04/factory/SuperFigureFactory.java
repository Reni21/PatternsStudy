package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.SuperFigure;

public class SuperFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new SuperFigure();
    }
}

package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.ZFigure;

public class ZFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new ZFigure();
    }
}

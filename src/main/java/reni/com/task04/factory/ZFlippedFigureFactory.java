package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.ZFlippedFigure;

public class ZFlippedFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new ZFlippedFigure();
    }
}

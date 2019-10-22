package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.LFlippedFigure;

public class LFlippedFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LFlippedFigure();
    }
}

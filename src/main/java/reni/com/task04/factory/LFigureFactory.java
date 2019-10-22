package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.LFigure;

public class LFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LFigure();
    }
}

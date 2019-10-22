package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.TFigure;

public class TFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new TFigure();
    }
}

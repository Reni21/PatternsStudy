package reni.com.task04.factory;

import reni.com.task04.entity.Figure;
import reni.com.task04.entity.LineFigure;

public class LineFigureFactory implements FigureFactory {
    @Override
    public Figure createFigure() {
        return new LineFigure();
    }
}

package reni.com.factorymethod.entity;

public class LFlippedFigure extends Figure {
    public LFlippedFigure() {
        super(new char[][]{
                {' ', 'X'},
                {' ', 'X'},
                {'X', 'X'}
        });
    }
}

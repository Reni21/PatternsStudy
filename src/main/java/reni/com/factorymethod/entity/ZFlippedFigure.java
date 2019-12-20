package reni.com.factorymethod.entity;

public class ZFlippedFigure extends Figure {
    public ZFlippedFigure() {
        super(new char[][]{
                {'X', ' '},
                {'X', 'X'},
                {' ', 'X'}
        });
    }
}

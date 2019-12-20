package reni.com.factorymethod.entity;

public class ZFigure extends Figure {
    public ZFigure() {
        super(new char[][]{
                {' ', 'X'},
                {'X', 'X'},
                {'X', ' '}
        });
    }
}

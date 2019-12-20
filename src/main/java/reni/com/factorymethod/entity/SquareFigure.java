package reni.com.factorymethod.entity;

public class SquareFigure extends Figure {
    public SquareFigure() {
        super(new char[][]{
                {'X', 'X'},
                {'X', 'X'}
        });
    }
}

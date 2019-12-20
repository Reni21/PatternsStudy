package reni.com.factorymethod.entity;

public class SuperFigure extends Figure {
    public SuperFigure() {
        super(new char[][]{
                {' ', 'X', 'X'},
                {' ', 'X', 'X'},
                {'X', 'X', 'X'},
                {'X', 'X', ' '},
                {'X', 'X', ' '}
        });
    }
}

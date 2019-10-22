package reni.com.task04.entity;

public abstract class Figure {
    private char[][] figureBody;

    public Figure(char[][] figureBody) {
        this.figureBody = figureBody;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        for (char[] chars : figureBody) {
            for (char ch : chars) {
                res.append(ch);
            }
            res.append('\n');
        }
        return res.toString();
    }
}

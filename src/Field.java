import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Field {
    private boolean gameEnd;
    private int height, width;

    private Cell[][] field, previousField;

    public Field(int height, int width) {
        this.height = height;
        this.width = width;
        gameEnd = false;

        field = new Cell[height][width];
        previousField = new Cell[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                field[i][j] = new Cell(State.randomState());
    }

    public Field(int height, int width, int[][] arr) {
        this.height = height;
        this.width = width;
        gameEnd = false;

        field = new Cell[height][width];
        previousField = new Cell[height][width];

        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (arr[i][j] > 0) field[i][j] = new Cell(State.ALIVE);
                else field[i][j] = new Cell(State.DEAD);
    }

    private ArrayList<Cell> findNeighbors(int x, int y) {
        ArrayList<Cell> result = new ArrayList<>();
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++) {
                if ((i == 0) && (j == 0)) continue;
                int newX = (x + i) % height < 0 ? (x + i) + height : (x + i) % height;
                int newY = (y + j) % width < 0 ? (y + j) + width : (y + j) % width;
                result.add(previousField[newX][newY]);
            }
        return result;
    }

    public boolean isGameEnd() {
        if (gameEnd) return true;
        boolean allDead = true;
        label:
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (field[i][j].getState() == State.ALIVE) {
                    allDead = false;
                    break label;
                }
        return allDead;
    }

    public void nextDay() {
        boolean changed = false;
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                previousField[i][j] = new Cell(field[i][j].getState());
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++) {
                if (field[i][j].NextState(findNeighbors(i, j))) changed = true;
            }
        if (!changed) gameEnd = true;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                result = result.append(field[i][j]);
            result = result.append('\n');
        }
        return result.toString();
    }
}

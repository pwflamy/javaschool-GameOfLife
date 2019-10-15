import java.util.ArrayList;

/**
 * Класс Cell реализует клетку игры
 */
public class Cell {
    private State state;

    /**
     * Создает экземляр клетки с начальным состоянием
     * @param state начальное состояние клетки
     */
    public Cell(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

    /**
     * Определяет следующее состояние клетки на основании ее соседей
     * @param neighbors список соседей клетки
     * @return true - состояние клетки измененено, false - состояние
     * не менялось
     */
    public boolean NextState(ArrayList<Cell> neighbors) {
        int aliveNeighbors = 0;
        for (Cell cell : neighbors) {
            if (cell.state == State.ALIVE) aliveNeighbors++;
        }
        switch (state) {
            case DEAD:
                if (aliveNeighbors == 3) {
                    state = State.ALIVE;
                    return true;
                }
                break;
            case ALIVE:
                if ((aliveNeighbors < 2) || (aliveNeighbors > 3)) {
                    state = State.DEAD;
                    return true;
                }
                break;
        }
        return false;
    }

    @Override
    public String toString() {
        //return state.toString();
        return (state == State.ALIVE) ? "*" : "-";
    }
}

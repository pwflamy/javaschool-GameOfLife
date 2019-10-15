import java.util.ArrayList;

public class Cell {
    public State state;

    public Cell(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }

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

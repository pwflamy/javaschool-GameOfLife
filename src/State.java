import java.util.Random;

public enum State {
    DEAD, ALIVE;

    private static final Random random = new Random();

    public static State randomState() {
        return State.values()[random.nextInt(State.values().length)];
    }
}

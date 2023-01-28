package pro6_5.exceptions;

public class GameNotCreated extends RuntimeException {
    public GameNotCreated() {
        super("Game not created");
    }
}

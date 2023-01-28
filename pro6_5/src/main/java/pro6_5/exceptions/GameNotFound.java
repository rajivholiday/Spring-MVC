package pro6_5.exceptions;

public class GameNotFound extends RuntimeException{
    public GameNotFound(){
        super("Game with this name not found");
    }
}

package pro6_5.exceptions;

public class UserNotFound extends RuntimeException{
    public UserNotFound(){
        super("user with this name not found");
    }
}

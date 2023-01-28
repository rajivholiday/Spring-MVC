package pro6_5.exceptions;

public class UserNotCreated extends RuntimeException {
    public UserNotCreated(){
        super("User not created");
    }
}

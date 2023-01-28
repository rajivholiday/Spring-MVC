package pro6_5.exceptions;

public class NotAuthorized extends RuntimeException{
    public NotAuthorized(){
        super("Not authorized");
    }
}

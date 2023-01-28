package pro6_5.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GameNotFound.class)
    public ResponseEntity<String> gameNotFound(GameNotFound exception){
        return  new ResponseEntity<>("Game not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(GameNotCreated.class)
    public ResponseEntity<String> gameNotCreated(GameNotCreated exception){
        return  new ResponseEntity<>("Game not crated", HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(UserNotFound.class)
    public ResponseEntity<String> userNotFound(UserNotFound exception){
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(UserNotCreated.class)
    public ResponseEntity<String> userNotCreated(UserNotCreated excetion){
        return  new ResponseEntity<>("User not created", HttpStatus.FORBIDDEN);
    }
    @ExceptionHandler(NotAuthorized.class)
    public ResponseEntity<String > notAuthorized(NotAuthorized exception){
        return  new ResponseEntity<>("username or password is wrong", HttpStatus.UNAUTHORIZED);
    }

}

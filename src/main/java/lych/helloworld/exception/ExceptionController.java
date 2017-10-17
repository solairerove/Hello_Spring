package lych.helloworld.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionController {


    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity nullPointer() {
        return ResponseEntity.badRequest().body("Some fields are empty or there is no such student!!!!");
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    public ResponseEntity badRequest() {
        return ResponseEntity.badRequest().body("You made a bad request, check the correctness of the passed arguments!!!");
    }
}

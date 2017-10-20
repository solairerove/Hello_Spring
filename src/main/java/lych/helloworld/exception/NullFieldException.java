package lych.helloworld.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class NullFieldException extends Exception {

    private static final long serialVersionUID = -4347819462368837002L;

    @ExceptionHandler(NullFieldException.class)
    public ResponseEntity internalServerError() {

        log.info("Any field is empty!!!");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Any field is empty!!!");
    }

}

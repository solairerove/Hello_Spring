package lych.helloworld.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class NoExistException extends Exception {

    private static final long serialVersionUID = -8521432714219137741L;

    @ExceptionHandler(NoExistException.class)
    public ResponseEntity studentNoExist() {

        log.info("Student not exist!!!");

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Student not exist!!!");
    }
}

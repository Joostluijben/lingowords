package joost.luijben.infrastructure.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import java.io.IOException;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    private ResponseEntity<ErrorModel> handleEntityNotFound(EntityNotFoundException ex) {
        ErrorModel error = new ErrorModel(HttpStatus.NOT_FOUND, "Entity not found", ex.getMessage());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(IOException.class)
    private ResponseEntity<ErrorModel> handleFileNotFound(IOException ex) {
        ErrorModel error = new ErrorModel(HttpStatus.INTERNAL_SERVER_ERROR, "Something went wrong on the server", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}


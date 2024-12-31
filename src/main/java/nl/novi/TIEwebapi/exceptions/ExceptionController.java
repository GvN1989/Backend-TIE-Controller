package nl.novi.TIEwebapi.exceptions;

import nl.novi.TIEwebapi.exceptions.RecordNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity <String> handleRecordNotFoundException (RecordNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(IndexOutOfBoundsException.class)
    public ResponseEntity<String> handleIndexOutOfBoundsException() {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Television with the requested index not found");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException () {
        return ResponseEntity.created(null).body("televison");
    }

}

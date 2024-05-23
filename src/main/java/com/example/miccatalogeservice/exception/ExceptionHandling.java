package com.example.miccatalogeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(BookAlreadyExistsException.class)
    public ResponseEntity<String> handleAlreadyExists(BookAlreadyExistsException exception) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Book Already Exists");
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleAlreadyExists(BookNotFoundException exception) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book Not Found");
    }
}

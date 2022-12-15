package com.example.pro5_1.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class GlobalExceptionHandler {

    @ExceptionHandler(CityNotFoundException.class)
    public ResponseEntity<Object> handleEx(CityNotFoundException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CityNotCreatedException.class)
    public ResponseEntity<Object> handleEx2(CityNotCreatedException exception) {
        return new ResponseEntity<>(exception, HttpStatus.NO_CONTENT);
    }
}

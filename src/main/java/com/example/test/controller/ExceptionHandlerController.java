package com.example.test.controller;

import com.example.test.model.ErrorType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorType> handleMissingServletRequestParameterException(final EntityNotFoundException ex) {
        ErrorType errorType = new ErrorType(Integer.toString(HttpStatus.BAD_REQUEST.value()), ex.getMessage());
        return new ResponseEntity<>(errorType, HttpStatus.BAD_REQUEST);
    }
}

package com.anocha.learn.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MVCExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<List<String>> validationHandler(ConstraintViolationException ex) {
        return new ResponseEntity<List<String>>(ex.getConstraintViolations()
                .stream().map(err -> err.getMessage()).collect(Collectors.toList()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BindException.class)
    public ResponseEntity<List> bindErrors(BindException ex) {
        return new ResponseEntity(ex.getAllErrors(), HttpStatus.BAD_REQUEST);
    }
}

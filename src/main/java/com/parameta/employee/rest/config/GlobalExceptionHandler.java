package com.parameta.employee.rest.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Configuration class for the rest controller.
 * */

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Exception handler for the BindException type, thrown when the request did not pass hibernate
     * validation.
     *
     * @param bindException BindException throw to get error info.
     * @return ResponseEntity with the response error description to the client.
     * */
    @ExceptionHandler(BindException.class)
    public ResponseEntity bindExceptionHandler(BindException bindException) {
        List<String> errors = bindException.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());
        return new ResponseEntity(Collections.singletonMap("errors", errors), HttpStatus.BAD_REQUEST);
    }
}

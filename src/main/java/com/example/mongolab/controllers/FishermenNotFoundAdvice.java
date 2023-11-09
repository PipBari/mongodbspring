package com.example.mongolab.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class FishermenNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(FishermenNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String fishermanNotFoundHandler(FishermenNotFoundException ex) {
        return ex.getMessage();
    }
}

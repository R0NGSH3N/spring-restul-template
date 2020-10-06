package com.r0ngsh3n.restful.template.controller;

import com.r0ngsh3n.restful.template.model.ObjectResponse;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ObjectResponse<String> MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ObjectResponse(1001, "Input Paramter Invalid", objectError.getDefaultMessage());
    }

    @ExceptionHandler(SQLException.class)
    public ObjectResponse<String> SQLExceptionHandler(SQLException sqle){
        return new ObjectResponse(1001, "Database Error", sqle.getMessage());
    }
}

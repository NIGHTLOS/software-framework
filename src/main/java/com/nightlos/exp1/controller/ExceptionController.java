package com.nightlos.exp1.controller;

import com.nightlos.exp1.exception.XException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;

@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @ExceptionHandler(XException.class)
    public Map<String, Object> handleException(XException exception) {
        return Map.of("message", exception.getMessage());
    }
}

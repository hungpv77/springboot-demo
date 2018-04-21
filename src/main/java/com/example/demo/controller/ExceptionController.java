package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Hung V. PHAM
 *
 */
@ControllerAdvice
@Controller
public class ExceptionController {
    @ExceptionHandler(Exception.class)
    public String notFoundHandler(Exception ex) {
        return "error";
    }
}

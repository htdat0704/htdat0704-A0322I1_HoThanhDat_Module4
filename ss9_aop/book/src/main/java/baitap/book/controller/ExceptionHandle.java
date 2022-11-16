package baitap.book.controller;

import baitap.book.exception.UnavailableQuantityBookException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {

    @ExceptionHandler(UnavailableQuantityBookException.class)
    public String showErrorPage(){
        return "error";
    }
}

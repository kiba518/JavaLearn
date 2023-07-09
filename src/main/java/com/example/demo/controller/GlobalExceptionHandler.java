//package com.example.demo.controller;
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import javax.servlet.http.HttpServletRequest;
//import java.net.BindException;
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler  {
//
//    @ExceptionHandler(BindException.class)
//    public ErrorResult exceptionHandler(BindException e, HttpServletRequest request) {
//
//        String failMsg = e.getBindingResult().getFieldError().getDefaultMessage();
//        ErrorResult error = ErrorResult.fail(500, e, failMsg);
//        log.error("URL:{} ,绑定异常:{} ", request.getRequestURI(),failMsg);
//
//        return error;
//    }
//
//}
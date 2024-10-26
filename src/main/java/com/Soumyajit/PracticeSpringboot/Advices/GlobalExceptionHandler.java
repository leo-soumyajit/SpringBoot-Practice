package com.Soumyajit.PracticeSpringboot.Advices;


import com.Soumyajit.PracticeSpringboot.Exceptions.ResourceNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ApiError> ResourceNotFound(ResourceNotFound resourceNotFound){
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND , "Resource NOT found");
        return new ResponseEntity<>(apiError , HttpStatus.NOT_FOUND);
    }
}

package com.Soumyajit.PracticeSpringboot.Exceptions;

public class ResourceNotFound extends RuntimeException {
    public ResourceNotFound(String message) {
        super(message);
    }
}

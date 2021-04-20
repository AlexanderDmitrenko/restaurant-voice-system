package com.dmitrenko.restaurant.util.exception;

public class NotFoundException extends RuntimeException {
    public NotFoundException(String massage) {
        super(massage);
    }
}

package com.razz.JPA.exception;

public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super(message);
    }
}

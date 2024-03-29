package com.razz.DIusingjavaconfiguraiton.exception;

public class BookNotFound extends RuntimeException{
    public BookNotFound(String message) {
        super(message);
    }
}

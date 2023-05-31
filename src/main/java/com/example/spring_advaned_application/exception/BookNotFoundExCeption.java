package com.example.spring_advaned_application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BookNotFoundExCeption extends RuntimeException{
    public BookNotFoundExCeption() {
    }

    public BookNotFoundExCeption(String message) {
        super(message);
    }

    public BookNotFoundExCeption(String message, Throwable cause) {
        super(message, cause);
    }
}

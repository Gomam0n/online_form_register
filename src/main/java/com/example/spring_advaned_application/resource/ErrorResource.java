package com.example.spring_advaned_application.resource;

public class ErrorResource {
    private String message;
    public ErrorResource(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

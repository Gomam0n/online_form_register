package com.example.spring_advaned_application.resource;

public class InvalidErrorResource {
    private  String message;
    private Object errors;

    public InvalidErrorResource(String message, Object errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return message;
    }

    public Object getErrors() {
        return errors;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrors(Object errors) {
        this.errors = errors;
    }
}

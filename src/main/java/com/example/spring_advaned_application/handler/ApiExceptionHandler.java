package com.example.spring_advaned_application.handler;

import com.example.spring_advaned_application.exception.BookNotFoundException;
import com.example.spring_advaned_application.exception.InvalidRequestException;
import com.example.spring_advaned_application.resource.ErrorResource;
import com.example.spring_advaned_application.resource.FieldResource;
import com.example.spring_advaned_application.resource.InvalidErrorResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.nio.file.NotDirectoryException;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ApiExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @ExceptionHandler(BookNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleNotFound(RuntimeException e){
        ErrorResource errorResource = new ErrorResource(e.getMessage());
        ResponseEntity result = new ResponseEntity<Object>(errorResource, HttpStatus.NOT_FOUND);
        logger.warn("Return ------ {}", result);
        return result;
    }

    @ExceptionHandler(InvalidRequestException.class)
    @ResponseBody
    public ResponseEntity<?> handleInvalidRequest(InvalidRequestException e){
        Errors errors = e.getErrors();
        List<FieldResource> fieldResources = new ArrayList<>();
        List<FieldError> fieldErrors = errors.getFieldErrors();
        for(FieldError fieldError:fieldErrors){
            FieldResource fieldResource = new FieldResource(
                    fieldError.getObjectName(), fieldError.getField(),
                    fieldError.getCode(), fieldError.getDefaultMessage());
            fieldResources.add(fieldResource);
        }
        InvalidErrorResource ier = new InvalidErrorResource(e.getMessage(), fieldResources);
        ResponseEntity result = new ResponseEntity<Object>(ier, HttpStatus.BAD_REQUEST);
        logger.warn("Return ------ {}", result);
        return result;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<?> handleException(Exception e){
        logger.error("Error ---- {}", e.getMessage());
        return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

package com.example.spring_advaned_application.handler;

import com.example.spring_advaned_application.web.BookController;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// Original global handler
public class ControllerExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

   // @ExceptionHandler({Exception.class})
    public ModelAndView handlerException(HttpServletRequest request, Exception e) throws Exception {
        logger.error("Request URL : {} , Exception: {}", request.getRequestURL(), e.getMessage());
        if(AnnotationUtils.findAnnotation(e.getClass(), ResponseStatus.class) != null){
            throw e;
        }
        ModelAndView mav = new ModelAndView();
        mav.addObject("url", request.getRequestURL());
        mav.addObject("exception", e);


        StackTraceElement[] stackTraceElements = e.getStackTrace();
        List<String> stackTrace = new ArrayList<>();
        if (stackTraceElements != null) {
            stackTrace = Arrays.asList(stackTraceElements)
                    .stream()
                    .map(StackTraceElement::toString)
                    .toList();
        }

        for(String s:stackTrace){
            System.out.println(s);
        }
        mav.addObject("stackTrace", stackTrace);
        mav.setViewName("error/error");

        return mav;
    }
}

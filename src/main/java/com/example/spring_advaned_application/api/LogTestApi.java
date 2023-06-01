package com.example.spring_advaned_application.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestApi {
    private  final Logger  logger = LoggerFactory.getLogger(LogTestApi.class);
    @GetMapping("/log")
    public  String log(){
        String name = "zhang";
        String email = "qyf@123.com";
        logger.info("info --- log");
        logger.warn("warn --- log");
        logger.error("error --- log");
        logger.debug("debug --- log");
        logger.trace("debug --- log");
        logger.info("name : {}, email : {}", name, email);
        return "logtest";
    }
}

package com.example.bookstorebackend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    //curl -i -X POST -H 'Content-Type: application/json' -d'{"configuredLevel":"TRACE"}' localhost:8080/actuator/loggers/com.example.bookstorebackend
    private Logger logger= LoggerFactory.getLogger(HelloController.class.getName());

    @RequestMapping
    public String index(){
        logger.trace("Trace Message");
        logger.debug("Debug Message");
        logger.info("Info Message");
        logger.warn("Warn Message");
        logger.error("Error Message");
        return "OK!";
    }
}

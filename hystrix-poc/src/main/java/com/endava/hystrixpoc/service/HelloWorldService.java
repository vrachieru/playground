package com.endava.hystrixpoc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldService {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    public String getHelloMessage(String name) {
        log.info("Calling getHelloMessage @" + System.currentTimeMillis());
        
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {

        }
        
        return "Hello " + name + "!";
    }

    public String getHelloMessageFallback(String name) {
    	log.info("Calling getHelloMessageFallback @" + System.currentTimeMillis());
        return "Hello " + name + " Fallback!" + System.currentTimeMillis();
    }
}

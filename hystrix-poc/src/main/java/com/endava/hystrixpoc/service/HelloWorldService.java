package com.endava.hystrixpoc.service;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Component
public class HelloWorldService {
    private static final Logger log = LoggerFactory.getLogger(HelloWorldService.class);

    @HystrixCommand(
    		fallbackMethod = "getHelloMessageFallback",
    		commandProperties = {
    				@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "5000")
            }
    )
    public String getHelloMessage(String name) {
    	int delay = getRandomDelay();
    	
        log.info("Calling getHelloMessage @" + System.currentTimeMillis() + " with " + delay + "ms delay.");
        
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
        	// oops
        }
        
        return "Hello " + name + "!";
    }
    
    private int getRandomDelay() {
    	Random random = new Random();
    	return random.nextInt(9000) + 1000;
    }

    public String getHelloMessageFallback(String name) {
    	log.info("Calling getHelloMessageFallback @" + System.currentTimeMillis() + ".");
        return "Dang, sorry " + name + "! The command has timed out. Here, have a cookie.";
    }
    
    @HystrixCommand(fallbackMethod = "getScaryDependencyFallback")
    public String getScaryDependency() {
    	log.info("Calling getScaryString @" + System.currentTimeMillis() + ".");
        if (System.currentTimeMillis() % 2 == 0) {
            return "Scary content.";
        } else {
            throw new RuntimeException("Oh noes, the scary dependency got me!");
        }
    }

    public String getScaryDependencyFallback() {
    	log.info("Calling getScaryStringFallback @" + System.currentTimeMillis() + ".");
        return "Oh dear God! The horror! The horror!";
    }
}

package com.endava.hystrixpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endava.hystrixpoc.service.HelloWorldService;

@RestController
public class HelloWorldController {
	@Autowired
    private HelloWorldService helloWorldService;

    @RequestMapping("/hello")
    @ResponseBody
    public String helloWorld(@RequestParam(value="name", defaultValue="World") String name) {
        return this.helloWorldService.getHelloMessage(name);
    }
    
    @RequestMapping("/scary")
    @ResponseBody
    public String scaryDependency() {
    	return this.helloWorldService.getScaryDependency();
    }
}

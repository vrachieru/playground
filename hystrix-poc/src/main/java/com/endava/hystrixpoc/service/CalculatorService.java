package com.endava.hystrixpoc.service;

import org.springframework.stereotype.Component;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;


@Component
public class CalculatorService {

	@HystrixCommand(fallbackMethod = "substractWentWrong")
	public int substract(String first, String second) {
		return Integer.parseInt(first) - Integer.parseInt(second);
	}

	public String substractWentWrong(String first, String second) {
		return "something went wrong";
	}

	@HystrixCommand(fallbackMethod = "sumWentWrong", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "30000"),
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "4"),
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "60000"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") }, threadPoolProperties = {
			@HystrixProperty(name = "coreSize", value = "30"),
			@HystrixProperty(name = "metrics.rollingStats.timeInMilliseconds", value = "180000") })
	public int add(String first, String second) {
		return Integer.parseInt(first) + Integer.parseInt(second);
	}

	public String sumWentWrong(String first, String second) {
		return "something went wrong";
	}
}

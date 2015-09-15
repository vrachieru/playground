package com.endava.hystrixpoc.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.endava.hystrixpoc.service.CalculatorService;


@Controller
public class CalculatorController {
	
	@Autowired
	private CalculatorService calculateService;
	
	@RequestMapping("/sum")
	@ResponseBody
	public int getResult(@RequestParam String first, @RequestParam String second){
		return	calculateService.add(first, second);
	}
	
	@RequestMapping("/substract")
	@ResponseBody
	public int getSubstract(@RequestParam String first, @RequestParam String second){
		return calculateService.substract(first, second);
	}
}

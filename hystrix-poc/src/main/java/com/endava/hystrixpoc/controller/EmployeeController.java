package com.endava.hystrixpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.endava.hystrix.poc.model.Employee;
import com.endava.hystrixpoc.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;

	@RequestMapping("/getEmployeeById")
	@ResponseBody
	public Employee getEmployee(@RequestParam(value = "id") int id)  {
		return employeeService.getEmployeeById(id);

	}
}

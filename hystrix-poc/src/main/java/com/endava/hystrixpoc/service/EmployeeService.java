package com.endava.hystrixpoc.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.endava.hystrixpoc.model.Employee;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class EmployeeService {

	List<Employee> listOfEmployees;

	public EmployeeService() {
		listOfEmployees = new ArrayList<Employee>();
		listOfEmployees.add(new Employee("Jon", "Snow", 1, "steward in the Night's Watch"));
		listOfEmployees.add(new Employee("Robert", "Baratheon", 2, "king"));
		listOfEmployees.add(new Employee("Eddard", "Stark", 3, "ex Hand of the King "));
		listOfEmployees.add(new Employee("Khal", "Drogo", 4, "warlord"));
		listOfEmployees.add(new Employee("Tywin", "Lannister", 5, "Hand of the King "));
		listOfEmployees.add(new Employee("Jaqen", "H'ghar", 6, " Faceless Men"));
		listOfEmployees.add(new Employee("Ramsay", "Bolton", 7, "The Bastard of Bolton"));
		listOfEmployees.add(new Employee("Cersei", "Lannister", 8, "Mother queen"));
	}

	@HystrixCommand(fallbackMethod = "noEmployeeFound")
	public Employee getEmployeeById(int id) {

		for (Employee currentEmployee : listOfEmployees) {
			if (currentEmployee.getId() == id) {
				return currentEmployee;
			}
		}
		return null;
	}

	public String noEmployeeFound(int id) {
		return "No employee found for the searched id " + id;
	}
}

package com.endava.hystrixpoc.model;

public class Employee {
	private String firstName;
	private String lastName;
	private Double salary;
	private int holidaysPerYear;
	private int holidaysTaken;
	private String phoneNumber;
	private String email;
	private String position;
	private int id;

	public Employee(String firstName, String lastName, int id, String position) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setId(id);
		this.setPosition(position);
	}

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public int getHolidaysPerYear() {
		return holidaysPerYear;
	}

	public void setHolidaysPerYear(int holidaysPerYear) {
		this.holidaysPerYear = holidaysPerYear;
	}

	public int getHolidaysTaken() {
		return holidaysTaken;
	}

	public void setHolidaysTaken(int holidaysTaken) {
		this.holidaysTaken = holidaysTaken;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}

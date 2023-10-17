package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeService empService;
	
	//read all route
	@GetMapping("/employee")
	public List<Employee> getAllEmployee() {
		return empService.allEmployee();
	}
	//create one route
	@PostMapping("/employee/new")
	public Employee createEmployee(
			@ModelAttribute("newEmp") Employee newEmp
			) {
		return empService.createEmployee(newEmp);
	}
	//read one route
	@GetMapping("/employee/{id}")
	public Employee getOneEmployee(
			@PathVariable("id") Long id) {
		return empService.oneEmp(id);
	}
	
	//update one route
	@PutMapping("/employee/{id}")
	public Employee updateEmployeeById(
			@PathVariable("id") Long id,
			@ModelAttribute("employee") Employee employee
			) {
		return empService.updateEmployee(employee);
	}
	//Delete one Route
	@DeleteMapping("/employee/{id}")
	public void deleteEmployeeById(@PathVariable("id")Long id) {
		empService.deleteEmployee(id);
	}
	
}

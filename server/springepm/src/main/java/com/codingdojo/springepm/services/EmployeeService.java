package com.codingdojo.springepm.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.LoginEmployee;
import com.codingdojo.springepm.repositories.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	public Employee register(Employee newEmployee, BindingResult result) {
		// TO-DO - Reject values or register if no errors:
		        // Reject if email is taken (present in database)
				//1. find user in the DB by email
				Optional<Employee> optionalEmployee = empRepo.findByEmail(newEmployee.getEmail());
				//2. if the email is present, reject
				if(optionalEmployee.isPresent()){
					result.rejectValue("email", "Unique", "Email is already registered");
				}
		        // Reject if password doesn't match confirmation
				if(!newEmployee.getPassword().equals(newEmployee.getConfirm())) {
					result.rejectValue("email", "Matches", "Passwords do not match!");
				}
		        // if result has errors, return
				if(result.hasErrors()) {
					// Return null if result has errors
					return null;
				} 
		        // Hash and set password, save user to database
				String hashed = BCrypt.hashpw(newEmployee.getPassword(), BCrypt.gensalt());
				newEmployee.setPassword(hashed);
				return empRepo.save(newEmployee);
			}
			
			public Employee login(LoginEmployee newLoginEmployee, BindingResult result) {
		 // TO-DO - Reject values:
		    	// 1. Find user in the DB by email
				Optional<Employee> optionalEmployee = empRepo.findByEmail(newLoginEmployee.getEmail());
				// 2. if the email is not present, reject
				if(optionalEmployee.isEmpty()){ 
					result.rejectValue("email", "Unique", "Email is not registered");
					return null;
				}
				// 3.1 grab the user from potential user
				Employee employee = optionalEmployee.get();
				// 3.2 if BCrypt password match fails
				if(!BCrypt.checkpw(newLoginEmployee.getPassword(), employee.getPassword())) {
					result.rejectValue("password", "Matches", "Invalid Password!");
				}
				// 4. if result has errors, return
				if(result.hasErrors()) {
					// Return null if result has errors
					return null;
				}
		        // Otherwise, return the user object
				return employee;
				
			}
			
			//find all
			public List<Employee> allEmployee(){
				return empRepo.findAll();
			}
			
			//find one
			public Employee oneEmp(Long id) {
				Optional<Employee> optionalEmployee = empRepo.findById(id);
				if(optionalEmployee.isPresent()) {
					return optionalEmployee.get();
				} else {return null;}
			}
			
			//create one
			public Employee createEmployee(Employee newEmp) {
				return empRepo.save(newEmp);
			}
			//update
			public Employee updateEmployee(Employee oneEmp) {
				return empRepo.save(oneEmp);
			}
			//delete
			public void deleteEmployee(Long id) {
				empRepo.deleteById(id);
			}
			
}

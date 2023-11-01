package com.codingdojo.springepm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.Project;
import com.codingdojo.springepm.repositories.EmployeeRepository;
import com.codingdojo.springepm.repositories.ProjectRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository empRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	
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
		//enroll Employee into project
		public void assignEmployeeToProject(Employee employee, Project project) {
		    if (!employee.getProject().contains(project)) {
		        employee.getProject().add(project);
		        project.getEmployee().add(employee);
		        empRepo.save(employee);
		        projectRepo.save(project);
		    }
		}

		//unenroll Employee out of project
		public void unassignEmployeeFromProject(Employee employee, Project project) {
		    if (employee.getProject().contains(project)) {
		        employee.getProject().remove(project);
		        project.getEmployee().remove(employee);
		        empRepo.save(employee);
		        projectRepo.save(project);
		    }
		}

		
}

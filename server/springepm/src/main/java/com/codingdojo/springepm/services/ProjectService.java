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
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
    private EmployeeRepository employeeRepo;
	
	//find all
	public List<Project> allProject(){
		return projectRepo.findAll();
	}
	
	//find one
	public Project onePro(Long id) {
		Optional<Project> optionalProject = projectRepo.findById(id);
		if(optionalProject.isPresent()) {
			return optionalProject.get();
		} else {return null;}
	}
	
	//create one
	public Project createProject(Project newPro) {
		return projectRepo.save(newPro);
	}
	//update
	public Project updateProject(Project onePro) {
		return projectRepo.save(onePro);
	}
	//delete
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	public void associateProjectWithEmployee(Long projectId, Long employeeId) {
		// Retrieve the project and employee from their respective repositories
		Optional<Project> optionalProject = projectRepo.findById(projectId);
		Optional<Employee> optionalEmployee = employeeRepo.findById(employeeId);
		
		if (optionalProject.isPresent() && optionalEmployee.isPresent()) {
			Project thisProject = optionalProject.get();
			Employee thisEmployee = optionalEmployee.get();
			
			// Add the project to the employee's list of projects
			thisEmployee.getProject().add(thisProject);
			
			// Save the employee since changes were made to their project list
			employeeRepo.save(thisEmployee);
		}
	}
}

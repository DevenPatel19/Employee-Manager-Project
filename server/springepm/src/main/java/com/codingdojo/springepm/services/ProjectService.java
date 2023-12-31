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
	//enroll Employee into project
	public void assignEmployeeToProject(Employee employee, Project project) {
	    if (!employee.getProject().contains(project)) {
	        employee.getProject().add(project);
	        project.getEmployee().add(employee);
	        employeeRepo.save(employee);
	        projectRepo.save(project);
	    }
	}

	//unenroll Employee out of project
	public void unassignEmployeeFromProject(Employee employee, Project project) {
	    if (employee.getProject().contains(project)) {
	        employee.getProject().remove(project);
	        project.getEmployee().remove(employee);
	        employeeRepo.save(employee);
	        projectRepo.save(project);
	    }
	}
	// Retrieve assigned employees for a project
	public List<Employee> getAssignedEmployees(Project project) {
        // Assuming you have a method in the Project entity class to get the list of assigned employees.
        // Make sure to replace "getEmployees()" with the actual method in your Project entity.
        return project.getEmployee();
    }
	
}

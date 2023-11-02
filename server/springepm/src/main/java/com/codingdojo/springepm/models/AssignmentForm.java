package com.codingdojo.springepm.models;

import java.util.List;

public class AssignmentForm {
    private Long employeeId;
    private Long projectId;
    private List<Project> availableProjects;
    private List<Project> assignedProjects;
    private List<Employee> availableEmployees;
    private List<Employee> assignedEmployees;
    

    
    public Long getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    // Getter method for availableProjects
    public List<Project> getAvailableProjects() {
    	return availableProjects;
    }
    
    
    // Setter method for availableProjects
    public void setAvailableProjects(List<Project> availableProjects) {
        this.availableProjects = availableProjects;
    }
    
    // Getter method for assignedProjects
    public List<Project> getAssignedProjects() {
    	return assignedProjects;
    }

    // Setter method for assignedProjects
    public void setAssignedProjects(List<Project> assignedProjects) {
        this.assignedProjects = assignedProjects;
    }

	public List<Employee> getAvailableEmployees() {
		return availableEmployees;
	}

	public void setAvailableEmployees(List<Employee> availableEmployees) {
		this.availableEmployees = availableEmployees;
	}

	public List<Employee> getAssignedEmployees() {
		return assignedEmployees;
	}

	public void setAssignedEmployees(List<Employee> assignedEmployees) {
		this.assignedEmployees = assignedEmployees;
	}
    
    
}


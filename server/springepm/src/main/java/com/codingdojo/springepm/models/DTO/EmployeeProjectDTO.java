package com.codingdojo.springepm.models.DTO;

import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.Project;

import jakarta.validation.constraints.NotNull;

public class EmployeeProjectDTO {

	@NotNull
	private Employee employee;
	
	@NotNull
	private Project project;
	
	public EmployeeProjectDTO() {}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	};
	
	
}

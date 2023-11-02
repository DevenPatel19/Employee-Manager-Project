package com.codingdojo.springepm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.springepm.models.AssignmentForm;
import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.Project;
import com.codingdojo.springepm.repositories.EmployeeRepository;

@Service
public class AssignmentFormService {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeRepository employeeRepo;

    // Populate the AssignmentForm with available and assigned projects for an employee
    public AssignmentForm populateAssignmentForm(AssignmentForm assignmentForm, Long employeeId) {
        // Retrieve the employee by ID from the database
        Employee employee = employeeRepo.findById(employeeId).orElse(null);

        if (employee != null) {
            // If the employee exists, retrieve a list of all available projects
            List<Project> allProjects = projectService.allProject();

            // Retrieve the list of projects currently assigned to the employee
            List<Project> assignedProjects = employee.getProject();

            // Set the available and assigned projects in the AssignmentForm
            assignmentForm.setAvailableProjects(allProjects);
            assignmentForm.setAssignedProjects(assignedProjects);
        }

        return assignmentForm;
    }
    
}

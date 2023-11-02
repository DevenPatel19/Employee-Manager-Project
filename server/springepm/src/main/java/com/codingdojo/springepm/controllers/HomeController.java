package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.codingdojo.springepm.models.AssignmentForm;
import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.Project;
import com.codingdojo.springepm.services.AssignmentFormService;
import com.codingdojo.springepm.services.EmployeeService;
import com.codingdojo.springepm.services.ProjectService;

@Controller
public class HomeController {

    @Autowired
    private EmployeeService empService;

    @Autowired
    private ProjectService proService;
    
    @Autowired
    private AssignmentFormService assignmentFormService;

    // Dain dashboard
    @GetMapping("/dashboard")
    public String renderDashboard(Model model) {
        List<Employee> allEmployee = empService.allEmployee();
        model.addAttribute("allEmployee", allEmployee);
        List<Project> allProject = proService.allProject();
        model.addAttribute("allProject", allProject);
        return "dashboard.jsp";
    }

    // Single employee detail
    @GetMapping("/employee/{id}")
    public String renderEmployeeDetails(
            @PathVariable("id") Long id, Model model) {
        Employee oneEmp = empService.oneEmp(id);
        model.addAttribute("oneEmp", oneEmp);
        List<Project> allProject = proService.allProject();
        model.addAttribute("allProject", allProject);
        return "employeeDetails.jsp";
    }

    // Single employee new add form
    @GetMapping("/employee/new")
    public String renderNewEmployeeForm(@ModelAttribute("newEmp") Employee newEmp) {
        return "employeeAdd.jsp";
    }

    @PostMapping("/employee/new")
    public String processNewEmployee(@ModelAttribute("newEmp") Employee newEmployee) {
        empService.createEmployee(newEmployee);
        return "redirect:/dashboard";
    }

    // Single employee edit details form
    @GetMapping("/employee/{id}/edit")
    public String showUpdateEmployeeForm(@PathVariable Long id, Model model) {
        Employee oneEmp = empService.oneEmp(id);
        model.addAttribute("oneEmp", oneEmp);
        return "employeeEdit.jsp";
    }

    
    // Single employee edit detail processing
    @PutMapping("/employee/{id}/edit")
    public String processUpdateEmployee(@ModelAttribute("oneEmp") Employee oneEmp) {
    	
        empService.updateEmployee(oneEmp);
        return "redirect:/employee/" + oneEmp.getId(); // Redirect to the employee details page
    }
    
    // Single employee delete
    @DeleteMapping("/employee/{id}")
    public String deleteEmployee(@PathVariable("id") Long id) {
    	empService.deleteEmployee(id);
    	return "redirect:/dashboard";
    }

    @GetMapping("/employee/{id}/assign")
    public String renderAssignForm(@PathVariable Long id, Model model) {
        Employee employee = empService.oneEmp(id);
        List<Project> allProjects = proService.allProject();
//
//      
//
        model.addAttribute("employee", employee);
        model.addAttribute("allProjects", allProjects);

        // Create a form object to hold the selected project ID
        AssignmentForm assignForm = new AssignmentForm();
        model.addAttribute("assignForm", assignForm);

        return "assignproject.jsp";
    }
    
    // Process assign employee
    @PostMapping("/employee/{employeeId}/assign")
    public String processAssignmentForm(
            @PathVariable Long employeeId, @RequestParam Long projectId) {
        Employee employee = empService.oneEmp(employeeId);
        Project project = proService.onePro(projectId);

        // Ensure the project is not already assigned to the employee
        if (!employee.getProject().contains(project)) {
            employee.getProject().add(project);
            empService.createEmployee(employee);
        }

        empService.assignEmployeeToProject(employee, project);

        return "redirect:/dashboard";
    }
   
    @GetMapping("/project/{id}/unassign")
    public String getAssignedEmployees(@PathVariable String id, Model model) {
        // Convert the id to a Long
        Long projectId;
        try {
            projectId = Long.parseLong(id);
        } catch (NumberFormatException e) {
            // Handle the exception or return an error page
            return "redirect:/project/{id}/unassign"; 
        }

        Project project = proService.onePro(projectId);
        List<Employee> assignedEmployees = proService.getAssignedEmployees(project);

        AssignmentForm unassignForm = new AssignmentForm();

        model.addAttribute("project", project);
        model.addAttribute("assignedEmployees", assignedEmployees);
        model.addAttribute("unassignForm", unassignForm);

        return "unassignEmployee.jsp";
    }


    
//    // Process unassign employee from project
    @PostMapping("/project/{projectId}/unassign")
    public String unassignEmployee(
            @PathVariable("projectId") Long projectId,
            @RequestParam("employeeId") Long employeeId) {
        // Retrieve the project and employee entities
        Project project = proService.onePro(projectId);
        Employee employee = empService.oneEmp(employeeId);

        if (project != null && employee != null) {
            // Remove the employee from the project's assignedEmployees
            project.getEmployee().remove(employee);
            proService.createProject(project);
        }

        // Redirect to the project details page or wherever you want
        return "redirect:/project/" + projectId;
    }


    
    // Single project new add form
    @GetMapping("/project/new")
    public String renderNewProjectForm(@ModelAttribute("newPro") Project newPro) {
        return "projectAdd.jsp";
    }
    // Single project new form processing
    @PutMapping("/project/new")
    public String processNewProject(@ModelAttribute("newPro") Project newPro) {
        proService.createProject(newPro);
        return "redirect:/dashboard";
    }

    // single project detail
    @GetMapping("/project/{id}")
    public String renderProjectDetails(
            @PathVariable("id") Long id, Model model) {
        Project onepro = proService.onePro(id);
        model.addAttribute("onePro", onepro);
        List<Employee> allEmployee = empService.allEmployee();
        model.addAttribute("allEmployee", allEmployee);
        return "projectDetails.jsp";
    }
    
    // single Project edit details form
    @GetMapping("/project/{id}/edit")
    public String showUpdateProjectForm(@PathVariable Long id, Model model) {
        Project onePro = proService.onePro(id);
        model.addAttribute("onePro", onePro);
        return "projectEdit.jsp";
    }

    // single employee edit detail processing
    @PutMapping("/project/{id}/edit")
    public String processUpdateProject(@ModelAttribute("onePro") Project onePro) {
        proService.updateProject(onePro);
        return "redirect:/project/{id}"; // Redirect to the employee details page
    }
    
    @DeleteMapping("/project/{id}")
    public String deleteProject(@PathVariable("id") Long id) {
    	proService.deleteProject(id);
    	return "redirect:/dashboard";
    }
}

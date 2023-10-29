package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.springepm.models.Employee;
import com.codingdojo.springepm.models.Project;
import com.codingdojo.springepm.services.EmployeeService;
import com.codingdojo.springepm.services.ProjectService;

@Controller
public class HomeController {

	@Autowired
	private EmployeeService empService;
	
	@Autowired
	private ProjectService proService;
	
	// main dashboard
	@GetMapping("/dashboard")
	public String renderDashboard(Model model) {
		List<Employee> allEmployee = empService.allEmployee();
		model.addAttribute("allEmployee", allEmployee);
		List<Project> allProject = proService.allProject();
		model.addAttribute("allProject", allProject);
		return "dashboard.jsp";
	}
	//single employee detail
	@GetMapping("/employee/{id}")
	public String renderEmployeeDetails(
			@PathVariable("id")Long id, Model model) {
		Employee oneEmp = empService.oneEmp(id);
		model.addAttribute("oneEmp", oneEmp);
		List<Project> allProject = proService.allProject();
		model.addAttribute("allProject", allProject);
		return "employeeDetails.jsp";
	}
	
	//single employee new add form
	@GetMapping("/employee/new")
	public String renderNewEmployeeForm(@ModelAttribute("newEmp")Employee newEmp
			) {
		return "employeeAdd.jsp";
	}
	
	@PostMapping("/employee/new")
	public String processNewEmployee(@ModelAttribute("newEmp") Employee newEmployee) {
	    empService.createEmployee(newEmployee); 
	    return "redirect:/dashboard"; 
	}
	
	//single employee edit details form
	 @GetMapping("/employee/{id}/edit")
	    public String showUpdateEmployeeForm(@PathVariable Long id, Model model) {
		 	Employee oneEmp = empService.oneEmp(id);
		 	List<Project> allProjects = proService.allProject();
	        model.addAttribute("oneEmp", oneEmp);
	        model.addAttribute("allProjects", allProjects);
	        return "employeeEdit.jsp";
	    }
	 
	 //single employee edit detail processing
	 @PutMapping("/employee/{id}/edit")
	    public String processUpdateEmployee(@ModelAttribute("employee") Employee updatedEmployee) {
	        empService.updateEmployee(updatedEmployee);
	        return "redirect:/employee/{id}"; // Redirect to the employee details page
	    }
	
	//single project detail
		@GetMapping("/project/{id}")
		public String renderProjectDetails(
				@PathVariable("id")Long id, Model model) {
			Project onePro = proService.onePro(id);
			
			return "projectDetails.jsp";
		}
	// Enroll an Employee in a Project
	    @PostMapping("/employee/{employeeId}/enroll/{projectId}")
	    public String enrollEmployeeInProject(
	            @PathVariable Long employeeId,
	            @PathVariable Long projectId) {

	        Employee employee = empService.enrollEmployeeInProject(employeeId, projectId);

	        if (employee != null) {
	            return "redirect:/employee/" + employeeId; // Redirect to the employee details page
	        } else {
	            // Handle the case where either the employee or project is not found
	            // You can return an error page or redirect to an appropriate error route
	            return "errorPage.jsp";
	        }
	    }	
}

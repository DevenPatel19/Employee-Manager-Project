package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
	
	
	@GetMapping("/dashboard")
	public String renderDashboard(Model model) {
		List<Employee> allEmployee = empService.allEmployee();
		model.addAttribute("allEmployee", allEmployee);
		List<Project> allProject = proService.allProject();
		model.addAttribute("allProject", allProject);
		return "dashboard.jsp";
	}
	
	@GetMapping("/employee/{id}")
	public String renderEmployeeDetails(
			@PathVariable("id")Long id, Model model) {
		Employee oneEmp = empService.oneEmp(id);
		model.addAttribute("oneEmp", oneEmp);
		List<Project> allProject = proService.allProject();
		model.addAttribute("allProject", allProject);
		return "employeeDetails.jsp";
	}
}

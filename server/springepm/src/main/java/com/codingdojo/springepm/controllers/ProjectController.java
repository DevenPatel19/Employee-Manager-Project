package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.springepm.models.Project;
import com.codingdojo.springepm.services.ProjectService;

@RestController
@RequestMapping("/api")
public class ProjectController {

	@Autowired
	private ProjectService proService;
	
	//read all route
	@GetMapping("/project")
	public List<Project> getAllProject(){
		return proService.allProject();
	}
	//create one route
	@PostMapping("/project/new")
	public Project createProject(
			@ModelAttribute("newPro") Project newPro
			) {
		return proService.createProject(newPro);
		
	}
	//read one route
	@GetMapping("/project/{id}")
	public Project getOneProject(
			@PathVariable("id")Long id) {
		return proService.onePro(id);		
	}
	//update one route
	@PutMapping("project/{id}")
	public Project updateProjectById(
			@PathVariable("id") Long id,
			@ModelAttribute("project") Project project
			) {
		return proService.updateProject(project);
	}
	//Delete one Route
	@DeleteMapping("/project/{id}")
	public void deleteProjectById(@PathVariable("id")Long id) {
		proService.deleteProject(id);
	}
}

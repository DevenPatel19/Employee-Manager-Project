package com.codingdojo.springepm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    // single employee detail
    @GetMapping("/employee/{id}")
    public String renderEmployeeDetails(
            @PathVariable("id") Long id, Model model) {
        Employee oneEmp = empService.oneEmp(id);
        model.addAttribute("oneEmp", oneEmp);
        List<Project> allProject = proService.allProject();
        model.addAttribute("allProject", allProject);
        return "employeeDetails.jsp";
    }

    // single employee new add form
    @GetMapping("/employee/new")
    public String renderNewEmployeeForm(@ModelAttribute("newEmp") Employee newEmp) {
        return "employeeAdd.jsp";
    }

    @PostMapping("/employee/new")
    public String processNewEmployee(@ModelAttribute("newEmp") Employee newEmployee) {
        empService.createEmployee(newEmployee);
        return "redirect:/dashboard";
    }

    // single employee edit details form
    @GetMapping("/employee/{id}/edit")
    public String showUpdateEmployeeForm(@PathVariable Long id, Model model) {
        Employee oneEmp = empService.oneEmp(id);
        List<Project> allProjects = proService.allProject();
        model.addAttribute("oneEmp", oneEmp);
        model.addAttribute("allProjects", allProjects);
        return "employeeEdit.jsp";
    }

    
    // single employee edit detail processing
    @PutMapping("/employee/{id}/edit")
    public String processUpdateEmployee(@ModelAttribute("employee") Employee updatedEmployee) {
        empService.updateEmployee(updatedEmployee);
        return "redirect:/employee/{id}"; // Redirect to the employee details page
    }

    @PostMapping("/{employeeId}/assign/{projectId}")
    public String assignEmployeeToProject(@PathVariable Long employeeId, @PathVariable Long projectId) {
        Employee employee = empService.oneEmp(employeeId);
        Project project = proService.onePro(projectId);

        if (employee != null && project != null) {
            empService.assignEmployeeToProject(employee, project);
        }

        return "redirect:/employee/" + employeeId;
    }

    // Endpoint to unassign an employee from a project
    @PostMapping("/{employeeId}/unassign/{projectId}")
    public String unassignEmployeeFromProject(@PathVariable Long employeeId, @PathVariable Long projectId) {
        Employee employee = empService.oneEmp(employeeId);
        Project project = proService.onePro(projectId);

        if (employee != null && project != null) {
            empService.unassignEmployeeFromProject(employee, project);
        }

        return "redirect:/employee/" + employeeId;
    }

    // single project new add form
    @GetMapping("/project/new")
    public String renderNewProjectForm(@ModelAttribute("newPro") Project newPro) {
        return "projectAdd.jsp";
    }

    @PostMapping("/project/new")
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
    public String showUpdatePorjectForm(@PathVariable Long id, Model model) {
        Project onePro = proService.onePro(id);
        List<Employee> allEmployee = empService.allEmployee();
        model.addAttribute("onePro", onePro);
        model.addAttribute("allEmployee", allEmployee);
        return "projectEdit.jsp";
    }

    // single employee edit detail processing
    @PutMapping("/project/{id}/edit")
    public String processUpdateProject(@ModelAttribute("project") Project updatedProject) {
        proService.updateProject(updatedProject);
        return "redirect:/project/{id}"; // Redirect to the employee details page
    }
}

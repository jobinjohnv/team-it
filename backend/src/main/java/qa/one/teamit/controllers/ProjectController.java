package qa.one.teamit.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.one.teamit.model.Project;
import qa.one.teamit.service.ProjectService;
import qa.one.teamit.service.SecurityService;

@RestController
@RequestMapping("/api")
public class ProjectController {
	
	@Autowired
	public ProjectService projectService;
	
	@Autowired
	private SecurityService securityService;
	
	@GetMapping("/projects")
	public List<Project> getAllProjects() {
		return projectService.findAllProjects();
	}
	
	@GetMapping("/myprojects")
	public List<Project> getCurrentUserProjects(){
		return projectService.findCurrentUserProjects(securityService.getUserProfile().getUsername());
	}
	
	@PostMapping("/projects")
	public void saveProject(@RequestBody Project project) {
		projectService.save(project);
	}
	
	@GetMapping("/projects/{Id}")
	public Optional<Project> getProjectById(@PathVariable("Id") Long Id) {
		return projectService.findProjectById(Id);
	}

}

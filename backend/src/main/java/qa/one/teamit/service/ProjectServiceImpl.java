package qa.one.teamit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qa.one.teamit.model.Project;
import qa.one.teamit.repo.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	public ProjectRepository projectRepository;
	
	@Autowired
	private SecurityService securityService;
	
	

	@Override
	public void save(Project project) {
		project.setCreatedBy(securityService.getCurrentUser());
		projectRepository.save(project);
		
	}



	@Override
	public Optional<Project> findProjectById(Long Id) {
		return projectRepository.findById(Id);
	}



	@Override
	public List<Project> findAllProjects() {
		return projectRepository.findAll();
	}



	@Override
	public List<Project> findCurrentUserProjects(String username) {
		return projectRepository.findByCreatedBy(username);
	}


	
	

}

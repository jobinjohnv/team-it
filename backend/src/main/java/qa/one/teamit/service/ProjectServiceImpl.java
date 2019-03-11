package qa.one.teamit.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qa.one.teamit.model.Project;
import qa.one.teamit.model.User;
import qa.one.teamit.repo.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService{
	
	@Autowired
	public ProjectRepository projectRepository;
	
	@Autowired
	private SecurityService securityService;
	
	

	@Override
	public Project save(Project project, User user) {
		project.setCreatedBy(securityService.getCurrentUser());
		project.setUser(user);
		return projectRepository.save(project);
		
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

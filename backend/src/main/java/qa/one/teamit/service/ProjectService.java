package qa.one.teamit.service;


import java.util.List;
import java.util.Optional;

import qa.one.teamit.model.Project;
import qa.one.teamit.model.User;


public interface ProjectService {
	
	Project save(Project project, User user);
	
	Optional<Project> findProjectById(Long Id);
	
	List<Project> findAllProjects();

	List<Project> findCurrentUserProjects(String username);

}

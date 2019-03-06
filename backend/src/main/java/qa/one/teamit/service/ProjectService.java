package qa.one.teamit.service;


import java.util.List;
import java.util.Optional;

import qa.one.teamit.model.Project;


public interface ProjectService {
	
	void save(Project project);
	
	Optional<Project> findProjectById(Long Id);
	
	List<Project> findAllProjects();

	List<Project> findCurrentUserProjects(String username);

}

package qa.one.teamit.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import qa.one.teamit.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long>{
	
	public List<Project> findByCreatedBy(String username);
	

}

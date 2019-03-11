package qa.one.teamit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import qa.one.teamit.model.Team;


public interface TeamRepository extends JpaRepository<Team, Long> {
	

}

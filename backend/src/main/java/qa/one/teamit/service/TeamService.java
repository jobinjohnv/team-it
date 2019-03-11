package qa.one.teamit.service;

import java.util.List;

import qa.one.teamit.model.Team;

public interface TeamService {
	
	Team save(Team team);

	List<Team> findAll();
	

}

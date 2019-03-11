package qa.one.teamit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import qa.one.teamit.model.Team;
import qa.one.teamit.repo.TeamRepository;

@Service
public class TeamServiceImpl implements TeamService{
	
	@Autowired
	SecurityService securityService;
	
	@Autowired
	TeamRepository teamRepository;

	@Override
	public Team save(Team team) {
		return teamRepository.save(team);
	}

	@Override
	public List<Team> findAll() {
		return teamRepository.findAll();
	}

}

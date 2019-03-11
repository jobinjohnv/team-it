package qa.one.teamit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.one.teamit.model.Team;
import qa.one.teamit.service.TeamService;

@RestController
@RequestMapping("/api/v1")
public class TeamRestController {
	
	
	@Autowired
	TeamService teamService;
	
	@GetMapping("/teams")
	public List<Team> getAllTeams()
	{
		return teamService.findAll();
	}
	
	@PostMapping("/teams")
	public Team saveTeam(@RequestBody Team team){
		return teamService.save(team);
	}

	
}

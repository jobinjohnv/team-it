package qa.one.teamit.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import qa.one.teamit.model.Role;
import qa.one.teamit.repo.RoleRepository;

@RestController
@RequestMapping("/api/v1")
public class RolesRestController {
	
	@Autowired
	public RoleRepository roleRepository;
	
	@GetMapping("/allroles")
	public List<Role> getRoles()
	{
		return roleRepository.findAll();
	}
	
	@PostMapping("/roles")
	public Role addRoles(@RequestBody Role role) {
		return roleRepository.save(role);
	}
	

}

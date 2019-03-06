package qa.one.teamit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import qa.one.teamit.data.UserProfile;
import qa.one.teamit.data.loginObject;
import qa.one.teamit.model.User;
import qa.one.teamit.service.SecurityService;
import qa.one.teamit.service.UserService;
import qa.one.teamit.validator.UserValidator;

@RestController
@RequestMapping("/api/v1")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private SecurityService securityService;
	
	
	@PostMapping("/register")
	public ResponseEntity<HttpStatus> register(@RequestBody User user) {
		
		userService.save(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/userinfo")
	public UserProfile getUserInfo() {
		return securityService.getUserProfile();
		
	}
	
	@PostMapping("/userLogin")
	public String login(@RequestBody loginObject loginobject){
		
		return securityService.autoLogin(loginobject.getUsername(), loginobject.getPassword());
		
	}
	
	

}

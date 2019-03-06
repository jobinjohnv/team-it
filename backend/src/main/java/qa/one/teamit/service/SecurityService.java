package qa.one.teamit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import qa.one.teamit.data.UserProfile;

public interface SecurityService {
	
	String findLoggedInUsername();
	
	String autoLogin(String username, String password);

	String getCurrentUser();
	
	UserProfile getUserProfile();

	ResponseEntity<HttpStatus> apiLogin();

}

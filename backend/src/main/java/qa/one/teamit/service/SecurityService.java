package qa.one.teamit.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import qa.one.teamit.data.UserProfile;
import qa.one.teamit.model.User;

public interface SecurityService {
	
	String getCurrentUsername();
	
	String autologin(String username, String password);

	String getCurrentUser();
	
	User getUser();
	
	UserProfile getUserProfile();

	ResponseEntity<HttpStatus> apiLogin();

}

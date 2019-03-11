package qa.one.teamit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import qa.one.teamit.data.UserProfile;
import qa.one.teamit.model.User;


@Service
public class SecurityServiceImpl implements SecurityService {
	
	@Autowired
	private UserDetailsService userDetailsSerice;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserProfile userProfile;
	
	
	@Override
	public String getCurrentUser() {
		
		Authentication auth = SecurityContextHolder
				.getContext()
				.getAuthentication();

		return auth.getName();
		
		
	}
	


	@Override
	public User getUser() {
		
		return userService.findByUsername(getCurrentUser());
	}
	
	
	

	@Override
	public String getCurrentUsername() {
		Object userDetails = SecurityContextHolder
				.getContext()
				.getAuthentication()
				.getDetails();
		
		
		if (userDetails instanceof UserDetails) {
			return ((UserDetails)userDetails).getUsername();
		}
		return null;
	}
	
	

	@Override
	public String autologin(String username, String password) {
		System.out.println("Username is "+username+"| Passord is"+password);
		UserDetails userDetails = userDetailsSerice.loadUserByUsername(username);
		
		UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, password, userDetails.getAuthorities());
		
		authenticationManager.authenticate(usernamePasswordAuthenticationToken);
		
		if(usernamePasswordAuthenticationToken.isAuthenticated()) {
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
		
			//TO-DO change this to logger later  	
			System.out.println("Authentication Successfull for User : "+username);
			return "Authentication Successfull for User : "+username;
		}
		return null;
	}


	@Override
	public UserProfile getUserProfile() {
		String username = getCurrentUser();
		userProfile.setUsername(username);
		String firstName = userService.findByUsername(username).getFirstName();
		userProfile.setFirstname(firstName);
		return userProfile;
	}


	@Override
	public ResponseEntity<HttpStatus> apiLogin() {
		// TODO Auto-generated method stub
		return null;
	}




}

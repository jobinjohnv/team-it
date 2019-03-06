package qa.one.teamit.service;

import qa.one.teamit.model.User;

public interface UserService {
	
	void save(User user);
	
	User findByUsername(String username);
	

}

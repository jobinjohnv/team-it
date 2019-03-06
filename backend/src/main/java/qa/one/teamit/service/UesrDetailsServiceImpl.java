package qa.one.teamit.service;

import java.util.HashSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import qa.one.teamit.model.Role;
import qa.one.teamit.model.User;
import qa.one.teamit.repo.UserRepository;

@Service
public class UesrDetailsServiceImpl implements UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username){
		System.out.println("Username is "+username);
		User user = userRepository.findByUsername(username);
		if(user == null) throw new UsernameNotFoundException(username);
		
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
		
		for(Role role:user.getRoles()) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
		}
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), grantedAuthorities);
	}

}

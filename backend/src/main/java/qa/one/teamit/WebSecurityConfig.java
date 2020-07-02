package qa.one.teamit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import qa.one.teamit.data.UserProfile;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDtailsService;
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public UserProfile userProfile() {
		return new UserProfile();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.csrf()
		.disable();
		.authorizeRequests()
			.antMatchers("/resources/**", "/registration","/api/v1/userlogin","/api/v1/register","/login*",
					//"/css/**","/fonts/**","/images/**","/js/*","/vendor/**","/swagger**")
			.permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()  // This part is commented out or else the page will be navigated to login page if not authenticated
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
		.permitAll();
	}
	
	@Bean
    public AuthenticationManager customAuthenticationManager() throws Exception {
        return authenticationManager();
    }
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDtailsService).passwordEncoder(bCryptPasswordEncoder());
    }
	

	
}

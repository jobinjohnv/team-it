package qa.one.teamit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.one.teamit.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}

package qa.one.teamit.repo;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.one.teamit.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Set<Role> findByName(String name);
	
	boolean existsByName(String name);

}

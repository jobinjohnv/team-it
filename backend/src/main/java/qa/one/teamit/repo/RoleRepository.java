package qa.one.teamit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import qa.one.teamit.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}

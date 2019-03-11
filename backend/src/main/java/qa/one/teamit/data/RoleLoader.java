package qa.one.teamit.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import qa.one.teamit.model.Role;
import qa.one.teamit.repo.RoleRepository;

@Component
public class RoleLoader implements ApplicationRunner{
	

	    private RoleRepository roleRepository;

	    @Autowired
	    public void DataLoader(RoleRepository roleRepository) {
	        this.roleRepository = roleRepository;
	    }

		@Override
		public void run(ApplicationArguments args) throws Exception {
			if(!roleRepository.existsByName("sve"))
			{
				roleRepository.save(new Role("sve"));
			}
		}
	}


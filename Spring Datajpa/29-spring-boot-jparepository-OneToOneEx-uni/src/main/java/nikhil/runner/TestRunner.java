package nikhil.runner;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import nikhil.dao.IRoleRepository;
import nikhil.dao.IUserRepository;
import nikhil.entity.Role;
import nikhil.entity.User;


@Component
public class TestRunner implements CommandLineRunner {

	@Autowired
	private IUserRepository urepo;

	@Autowired
	private IRoleRepository rrepo;

	@Override
	public void run(String... args) throws Exception {

		Role r1 = new Role(503, "ADMIN");
		Role r2 = new Role(504, "GUEST");
		
		rrepo.save(r1);
		rrepo.save(r2);
		
		User u1 = new User(10, "SYED", r1);
		User u2 = new User(11, "SAM",  r2);
		//it will give error 
		//User u3 = new User(12, "RAM",  r1);
		
		
		urepo.save(u1);
		urepo.save(u2);	
	//	urepo.save(u3);
		
	}
}

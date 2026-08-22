package nikhil.service;

import nikhil.entity.User;

public interface IUserService {

	// save into database(during signin)
	public Integer saveUser(User user);

	// when logging with username and password check whether user if found or not
	public User findByUsername(String username);

}
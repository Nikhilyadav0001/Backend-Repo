package nikhil.service;

import java.util.Optional;

import nikhil.entity.User;

public interface IUserService {
	Integer saveUser(User user);
	Optional<User> getOneUser(Integer id);
}
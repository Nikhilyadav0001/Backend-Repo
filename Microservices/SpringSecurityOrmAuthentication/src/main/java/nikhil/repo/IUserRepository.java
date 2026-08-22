package nikhil.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUserEmail(String userEmail);
}

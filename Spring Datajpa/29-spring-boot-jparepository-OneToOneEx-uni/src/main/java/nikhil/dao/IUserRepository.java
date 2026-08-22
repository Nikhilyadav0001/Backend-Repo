package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.User;

public interface IUserRepository extends JpaRepository<User, Integer> {

}

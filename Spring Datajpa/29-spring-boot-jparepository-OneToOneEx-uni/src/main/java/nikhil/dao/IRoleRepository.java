package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Role;

public interface IRoleRepository extends JpaRepository<Role, Integer> {

}

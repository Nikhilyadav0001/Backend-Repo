package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IPersonRepository extends JpaRepository<nikhil.entity.Person, Integer> {

}
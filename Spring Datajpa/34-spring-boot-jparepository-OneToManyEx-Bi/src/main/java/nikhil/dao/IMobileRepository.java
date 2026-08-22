package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMobileRepository extends JpaRepository<nikhil.entity.MobileNumber, Long> {

}
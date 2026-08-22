package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.MarriageSeeker;

public interface IMarrigeRepository extends JpaRepository<MarriageSeeker, Integer> {

}

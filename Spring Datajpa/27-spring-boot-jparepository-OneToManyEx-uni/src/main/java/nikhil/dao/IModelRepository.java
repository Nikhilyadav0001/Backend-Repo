package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Model;

public interface IModelRepository extends JpaRepository<Model, Integer> {

}

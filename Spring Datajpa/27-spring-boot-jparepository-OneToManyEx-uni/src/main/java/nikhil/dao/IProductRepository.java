package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Product;

public interface IProductRepository extends JpaRepository<Product, Integer> {

}

package nikhil.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.entity.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {

}
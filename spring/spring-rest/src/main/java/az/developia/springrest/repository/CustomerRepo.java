package az.developia.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrest.model.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{

}

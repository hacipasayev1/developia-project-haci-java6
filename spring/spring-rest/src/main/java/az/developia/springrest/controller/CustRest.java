package az.developia.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Customer;
import az.developia.springrest.repository.CustomerRepo;
import az.developia.springrest.repository.OrderRepo;

@RestController
@RequestMapping(path="/customers")
@CrossOrigin(origins = "*")
public class CustRest {
@Autowired
private CustomerRepo repo;
@Autowired
private OrderRepo orderRepo;
@GetMapping
public List<Customer> findAll(){
	return repo.findAll();
}
@DeleteMapping(path="/{id}")
public void deleteById(@PathVariable Integer id) {
	//orderRepo.deleteAllByCustomerId(id);
	repo.deleteById(id);
	
}
}

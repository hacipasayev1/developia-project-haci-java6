package az.developia.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Order;
import az.developia.springrest.repository.OrderRepo;

@RestController
@RequestMapping(path="/orders")
@CrossOrigin(origins = "*")
public class OrderRest {
@Autowired
private OrderRepo repo;
@GetMapping
public List<Order> findAll(){
	return repo.findAll();
}
}

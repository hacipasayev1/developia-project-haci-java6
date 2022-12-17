package az.developia.computer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.computer.model.Computer;
import az.developia.computer.service.ComputerService;

@RestController
@RequestMapping(path="/computer")
public class StudentRestController {
@Autowired
private ComputerService service;

@GetMapping
public List<Computer> findAll(){
	return service.findAll();
}
@GetMapping(path="/{id}")
public Computer findById(@PathVariable Integer id) {
	Computer computer=service.findById(id);
	return computer;
}
@DeleteMapping(path="/{id}")
public void deleteById(@PathVariable Integer id) {
	service.deleteById(id);
}
@PostMapping
public Computer save(@RequestBody Computer computer) {
	computer.setId(null);
	service.save(computer);
	return computer;
}
@PutMapping
public Computer update(@RequestBody Computer computer) {
	if(computer.getId()==null || computer.getId()==null) {
		throw new RuntimeException("");
	}
	Computet c=service.findById(computer.getId())
			if(c=null) {
				throw new RuntimeException("");
			}
	service.save(computer);
	return computer;
}
}
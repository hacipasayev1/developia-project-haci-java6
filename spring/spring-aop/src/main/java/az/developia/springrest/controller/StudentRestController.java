package az.developia.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.exceptions.MyValidationException;
import az.developia.springrest.model.DataWrapper;
import az.developia.springrest.model.Student;
import az.developia.springrest.repository.StudentRepository;
import az.developia.springrest.service.StudentService;

@RestController
@RequestMapping(path="/students")
public class StudentRestController {
	@Autowired
	private StudentService service;
	@Autowired
	private StudentRepository repository;
	@GetMapping
	public DataWrapper findAll(){
		return service.findAll();
	}
	
	@GetMapping(path="/{id}")
	public Student findById(@PathVariable Integer id) {
		Student student=service.findById(id);
		return student;
	}

	@DeleteMapping(path="/{id}")
	public void deleteById(@PathVariable Integer id) {
	service.deleteById(id);
	}
	@PostMapping
	public Student save(@Valid @RequestBody Student student,BindingResult br) {
		if(br.hasErrors()) {
			throw new MyValidationException(br);
		}
	student.setId(null);
		service.save(student);
	
		return student;
	}
}

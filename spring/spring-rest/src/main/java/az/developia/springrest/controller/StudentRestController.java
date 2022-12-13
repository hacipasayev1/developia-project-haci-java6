package az.developia.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Student;
import az.developia.springrest.service.StudentService;

@RestController
@RequestMapping(path="/students")
public class StudentRestController {
@Autowired
private StudentService service;
@GetMapping
public List<Student> findAll(){
	return service.findAll();
}
}

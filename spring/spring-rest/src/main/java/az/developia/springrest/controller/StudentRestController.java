package az.developia.springrest.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Student;
import az.developia.springrest.service.StudentService;

@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins = "*")
public class StudentRestController {
	
	private List<Student> list;

@Autowired
private StudentService service;
boolean loadStudents=false;

@GetMapping
@PreAuthorize(value = "hasAuthority('student:find:all')")
public List<Student> findAll(){
	if(loadStudents) {
		
	}else {
		list=service.findAll();
		loadStudents=true;
	}
	return list;
}

@GetMapping(path="/{id}")
@PreAuthorize(value = "hasAuthority('student:find:one')")

public Student findById(@PathVariable Integer id) {
	Student student=service.findById(id);
	return student;
}

@DeleteMapping(path="/{id}")
@PreAuthorize(value = "hasAuthority('student:delete')")

public void deleteById(@PathVariable Integer id) {
service.deleteById(id);
}
@PostMapping
public Student save(@RequestBody Student student) {
	student.setId(null);
	service.save(student);
	list.add(student);
	return student;
}
@PutMapping
public Student update(@RequestBody Student student) {
	if(student.getId()==null || student.getId()==0) {
		throw new RuntimeException("id 0 yada null ola bilmez");
	}
	Student s=service.findById(student.getId());
	if (s==null) {
		throw new RuntimeException("id tapilmadi");
	}
	service.save(student);
	return student;
}
}
package az.developia.springmvcjdbc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springmvcjdbc.model.Student;
import az.developia.springmvcjdbc.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository repository;
	public List<Student> findAll(){
		return repository.findAll();
	}
	public void save(Student s) {
		repository.save(s);
		
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}
	public Student findById(Integer id) {
		
		return repository.findById(id);
	}
}

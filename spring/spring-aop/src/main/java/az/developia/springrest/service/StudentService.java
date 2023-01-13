package az.developia.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springrest.model.Student;
import az.developia.springrest.repository.StudentRepository;

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
		
		return repository.findById(id).get();
	}
}

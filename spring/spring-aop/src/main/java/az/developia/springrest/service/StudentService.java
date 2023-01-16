package az.developia.springrest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.springrest.model.DataWrapper;
import az.developia.springrest.model.Student;
import az.developia.springrest.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository repository;
	public DataWrapper findAll(){
		DataWrapper dw=new DataWrapper();
		dw.setStudents( repository.findAll());
		dw.setAge(12);
		return dw;
	}
	public void save(Student s) {
		repository.save(s);
		
	}
	public void deleteById(Integer id) {
		repository.deleteById(id);
		
	}
	public Student findById(Integer id) {
		 Optional<Student> finded = repository.findById(id);
		 if(finded.isPresent()) {
			 return finded.get();
		 }else {
			 return null;
		 }
		
	}
}

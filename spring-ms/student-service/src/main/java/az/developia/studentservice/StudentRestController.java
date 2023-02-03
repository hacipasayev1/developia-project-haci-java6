package az.developia.studentservice;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/students")
@CrossOrigin(origins = "*")
public class StudentRestController {
	@Autowired
private StudentRepository repository;
	@Autowired
	private Environment environment;
	@Autowired
	private MyConfig config;
	
	@GetMapping
	public DataWrapper findAll() {
		DataWrapper dataWrapper=new DataWrapper();
		List<Student> students=repository.findAll();
		dataWrapper.setStudents(students);
		return dataWrapper;
	}
	
	
	@GetMapping(path="/teacher/{teacherId}")
	public DataWrapper findAllByTeacherId(@PathVariable Integer teacherId) {
		DataWrapper dataWrapper=new DataWrapper();
		List<Student> students=repository.findAllByTeacherId(teacherId);
		dataWrapper.setStudents(students);
		String port = environment.getProperty("local.server.port");
		System.out.println(port);
		dataWrapper.setPort(port);
		System.out.println(config.getMin());
		System.out.println(config.getMax());
		return dataWrapper;
	}
}

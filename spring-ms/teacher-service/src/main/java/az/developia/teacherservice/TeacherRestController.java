package az.developia.teacherservice;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/teachers")
@CrossOrigin(origins = "*")
public class TeacherRestController {
	@Autowired
private TeacherRepository repository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	
	
	@GetMapping
	public DataWrapper findAll() {
		DataWrapper dataWrapper=new DataWrapper();
		List<Teacher> teachers=repository.findAll();
		dataWrapper.setTeachers(teachers);
		return dataWrapper;
	}
	
	@GetMapping(path="/with-students")
	public DataWrapper findAllWithStudents() {
		
		DataWrapper dataWrapper=new DataWrapper();//?
		List<Teacher> teachers=repository.findAll();
		List<TeacherDTO> teacherDtos=new ArrayList<>();
		for (Teacher t : teachers) {
		DataWrapper dw=restTemplate.getForEntity("http://student-service/students/teacher/"+t.getId(), DataWrapper.class).getBody();
		//?
		TeacherDTO dto=new TeacherDTO();
		dto.setId(t.getId());
		dto.setName(t.getName());
		dto.setSurname(t.getSurname());
		dto.setStudents(dw.getStudents());
		teacherDtos.add(dto);
		}
		dataWrapper.setTeacherDtos(teacherDtos);
		return dataWrapper;
	}
}

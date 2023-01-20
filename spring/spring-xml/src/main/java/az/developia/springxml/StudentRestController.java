package az.developia.springxml;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

import az.developia.springxml.loggers.MyLogger;

@RestController
@RequestMapping(path = "/students")
public class StudentRestController {
	private ArrayList<Student> students = new ArrayList<>();
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private MyLogger logger;

	@PostConstruct
	private void init() {
		students.addAll(List.of(new Student(1, "Adil", "Eliyev"), new Student(2, "Cavid", "Eliyev"),
				new Student(3, "Ayxan", "Eliyev")));
	}

	@GetMapping(produces = { "application/json" })
	public MappingJacksonValue findAll() {
		ArrayList<StudentDTO> dtos=new ArrayList<>();
		for (Student s : students) {
			StudentDTO dto=new StudentDTO();
			mapper.map(s, dto);
			dtos.add(dto);
		}
		logger.log("salam");
		return filter(dtos, "s", "id", "surname");
	}

	@GetMapping(path = "/with-id-name", produces = { "application/json" })
	public MappingJacksonValue findAllWithIdName() {

		return filter(students, "s", "id", "name");
	}
	
	@GetMapping(path = "/with-id-phone", produces = { "application/json" })
	public MappingJacksonValue findAllWithIdPhone() {

		return filter(students, "s", "id", "phone");
	}

	public MappingJacksonValue filter(Object data, String dto, String... fields) {
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
		FilterProvider provider = new SimpleFilterProvider().addFilter(dto, filter);
		MappingJacksonValue value = new MappingJacksonValue(data);
		value.setFilters(provider);
		return value;
	}
}

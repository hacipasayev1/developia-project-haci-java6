package az.developia.springmvcjdbc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.springmvcjdbc.model.Student;
import az.developia.springmvcjdbc.service.StudentService;

@Controller
@RequestMapping(path="/students")
public class StudentController {
@Autowired
	private StudentService service;
@GetMapping
public String showStudents(Model m) {
	List<Student> all = service.findAll();
	m.addAttribute("students", all);
	return "students";
	}
@GetMapping(path="/open-save-page")
public String openSavePage(Model m) {
	Student s=new Student();
	m.addAttribute("student", s);
	return "save-student";
	}
@PostMapping(path="/save")
public String save(@ModelAttribute(value="student")Student s) {
	service.save(s);
	 return "redirect:/students";
}
@GetMapping(path="/delete/{id}")
public String delete(@PathVariable Integer id) {
	service.deleteById(id);
	return "redirect:/students";
	
}
@GetMapping(path="/edit/{id}")
public String edit(@PathVariable Integer id,Model m) {
	Student s=service.findById(id);
	m.addAttribute("student", s);
	return "save-student";
	
}
}

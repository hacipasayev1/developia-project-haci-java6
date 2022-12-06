package az.developia.springmvcjdbc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
public String save(@Valid @ModelAttribute(value="student")Student s,BindingResult br) {
	if(br.hasErrors()) {
		return "save-student";
	}
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
List<Student> allcopy=new ArrayList<>();
@GetMapping(path="/search")
public String showStudentsGoogle(@RequestParam(name="sorgu",required = false,defaultValue = "")String sorgumuz) {
	List<Student> all = service.findAll();
	
	for(Student s:all) {
 		if(s.getName().contains(sorgumuz)||s.getSurname().contains(sorgumuz)) {
 			allcopy.add(s);
 		}
	}
	
	return "redirect:/show-search-students";
}
	

	@GetMapping(path="/show-search-students")
	public String showSearchStudents(Model model) {
		model.addAttribute("students",allcopy);
		return "students";
	}
}

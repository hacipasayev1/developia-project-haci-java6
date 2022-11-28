package az.developia.springmvc.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import az.developia.springmvc.model.Student;

@Controller
public class StudentController {
@GetMapping(path="/students")
public String showStudents(Model model) {
	ArrayList<Student> studentObjects=new ArrayList<>();
	studentObjects.add(new Student(1,"Perviz","Veliyev","perviz@gmail.com"));
	studentObjects.add(new Student(2,"Adil","Eliyev","adil@gmail.com"));
	studentObjects.add(new Student(3,"Cavid","Hesenov","cavid@gmail.com"));
	model.addAttribute("telebeler", studentObjects);
	return "students";
}
@GetMapping(path="/my-books")
public String showbooks() {
	return "books";
}
@GetMapping(path="/google")
public String showStudentsGoogle(Model modelimiz,@RequestParam(name="sorgu",required = false,defaultValue = "")String sorgumuz) {
	ArrayList<Student> studentObjects=new ArrayList<>();
	
	studentObjects.add(new Student(1,"Perviz","Veliyev","perviz@gmail.com"));
	studentObjects.add(new Student(2,"Adil","Eliyev","adil@gmail.com"));
	studentObjects.add(new Student(3,"Cavid","Hesenov","cavid@gmail.com"));
	ArrayList<Student> studentObjectsCopy=new ArrayList<>();
	for(Student s:studentObjects) {
		if(s.getName().contains(sorgumuz)||s.getSurname().contains(sorgumuz)) {
			studentObjectsCopy.add(s);
		}
	}
	modelimiz.addAttribute("telebeler", studentObjectsCopy);
	return "students";
}


}

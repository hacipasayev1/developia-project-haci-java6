package az.developia.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
@GetMapping(path="/students")
public String showStudents() {
	return "students";
}
@GetMapping(path="/my-books")
public String showbooks() {
	return "books";
}
}

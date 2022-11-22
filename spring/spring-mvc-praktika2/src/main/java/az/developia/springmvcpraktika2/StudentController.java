package az.developia.springmvcpraktika2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {
@GetMapping(path="/students")
public String showStudents() {
	return "students";
}
}

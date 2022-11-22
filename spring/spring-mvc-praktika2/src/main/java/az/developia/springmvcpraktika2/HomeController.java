package az.developia.springmvcpraktika2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping(path="/home")
	public String showStudents() {
		return "home";
	}
}

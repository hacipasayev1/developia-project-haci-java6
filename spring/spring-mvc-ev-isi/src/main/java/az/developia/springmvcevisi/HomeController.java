package az.developia.springmvcevisi;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {
@GetMapping(path="/home")
public String showhome() {
	return "home";
}
}

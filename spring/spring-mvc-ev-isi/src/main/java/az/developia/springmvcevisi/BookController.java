package az.developia.springmvcevisi;

import org.springframework.web.bind.annotation.GetMapping;

public class BookController {
@GetMapping(path="/books")
public String showbooks() {
	return "books";
}
}

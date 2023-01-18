package az.developia.springrest.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Menu;
import az.developia.springrest.repository.MenuRepo;

@RestController
@RequestMapping(path="/menus")
@CrossOrigin(origins = "*")
public class MenuRestController {
	@Autowired
	private MenuRepo menuRepo;
@GetMapping
public List<Menu> getMenu(@RequestHeader (name="Accept-Language",required=false)Locale locale) {
	String language=locale.getLanguage();
	List<Menu> menus=menuRepo.findAllByLang(language);
	return menus;
}
}

package az.developia.Kitabqeydiyyati.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import az.developia.Kitabqeydiyyati.model.Book;
import az.developia.Kitabqeydiyyati.service.BookService;//?niye import




@Controller
@RequestMapping(path="/books")
public class BookController {
	@Autowired
	private BookService service;
@GetMapping
public String showBooks(Model model) {
	List<Book> all=service.findAll();
	model.addAttribute("books", all);
	return "books";
}
@GetMapping(path="/open-form")
public String openForm(Model model) {
	Book b=new Book();
	model.addAttribute("book",b);
	return "save-book";
}
@PostMapping(path="/save")
public String save(@ModelAttribute(value="book") Book b) {
	service.save(b);

	
	return "redirect:/books";
	
}
@GetMapping(path="/delete/{id}")
public String delete(@PathVariable Integer id) {
	service.deleteById(id);
	return "redirect:/books";
	
}
@GetMapping(path="/edit/{id}")
public String edit(@PathVariable Integer id,Model m) {
Book b=service.findById(id);
	
	m.addAttribute("book", b);
	return "save-book";
	
	
}
}

package az.developia.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import az.developia.springrest.model.Author;
import az.developia.springrest.model.Book;
import az.developia.springrest.model.BookDTO;
import az.developia.springrest.repository.AuthorRepo;
import az.developia.springrest.repository.BookRepo;

@RestController
@RequestMapping(path="/books")
@CrossOrigin(origins = "*")
public class BookRest {
@Autowired
private BookRepo repo;
@Autowired
private AuthorRepo authorRepo;
@GetMapping
public List<Book> findAll(){
	List<Book> all = repo.findAll();
	System.out.println("heleki kitablar gelib");
	System.out.println(all.get(0).getAuthors());
	return null;
}

@GetMapping(path="/authors")
public List<Author> findAllAuthors(){
	return authorRepo.findAll();
}

@DeleteMapping(path="/{id}")
public void deleteById(@PathVariable Integer id) {
	repo.deleteById(id);
}

@PostMapping
public void save(@RequestBody Book book) {
	repo.save(book);
}


@PostMapping(path="/save-with-authors")
public void saveWithAuthors(@RequestBody BookDTO dto) {
	Book book=new Book();
	book.setName(dto.getName());
	book.setPrice(dto.getPrice());
	for (Integer id : dto.getAuthorIds()) {
		Author a=authorRepo.findById(id).get();
		book.addAuthor(a);
	}
	repo.save(book);
}
}

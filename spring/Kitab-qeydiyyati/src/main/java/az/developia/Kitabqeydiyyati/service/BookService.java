package az.developia.Kitabqeydiyyati.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import az.developia.Kitabqeydiyyati.model.Book;
import az.developia.Kitabqeydiyyati.repository.BookRepository;
@Service
public class BookService {
	@Autowired
	private BookRepository repository;
	public List<Book> findAll(){
		return repository.findAll();
	}
	public void save(Book b) {
		repository.save(b);
		
	}
	public void deleteById(Integer id) {
	repository.deleteById(id);
		
	}
	public Book findById(Integer id) {
		
		return repository.findById(id);
	}
}

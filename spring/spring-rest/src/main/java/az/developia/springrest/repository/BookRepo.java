package az.developia.springrest.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrest.model.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}

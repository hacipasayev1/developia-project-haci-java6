package az.developia.springrest.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrest.model.Author;



public interface AuthorRepo extends JpaRepository<Author, Integer>{

}

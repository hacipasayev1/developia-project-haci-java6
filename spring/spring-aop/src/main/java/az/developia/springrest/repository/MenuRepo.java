package az.developia.springrest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrest.model.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{
List<Menu> findAllByLang(String lang);
}

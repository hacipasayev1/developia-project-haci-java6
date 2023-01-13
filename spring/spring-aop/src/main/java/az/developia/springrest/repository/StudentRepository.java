package az.developia.springrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import az.developia.springrest.model.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}

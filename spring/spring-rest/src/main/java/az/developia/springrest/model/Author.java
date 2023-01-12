package az.developia.springrest.model;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="authors")
@Getter
@Setter
public class Author {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name="book_author",
	joinColumns = @JoinColumn(name="author_id"),
	inverseJoinColumns = @JoinColumn(name="book_id"))
	@JsonIgnoreProperties(value = "authors")

	private List<Book> books;
	
	
	
	

}

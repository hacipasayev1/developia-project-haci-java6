package az.developia.springrest.model;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name="books")
@Getter
@Setter
public class Book {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String name;
	private Double price;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="book_author",
	joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="author_id"))
	@JsonIgnoreProperties(value = "books")
	private List<Author> authors;
	public void addAuthor(Author a) {
		if(authors==null) {
			authors=new ArrayList<>();
		}
		authors.add(a);
	}
	
	

}

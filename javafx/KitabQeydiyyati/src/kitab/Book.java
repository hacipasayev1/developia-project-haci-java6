package kitab;

import java.time.LocalDate;

public class Book {
	private Integer id;
private String name;
private String author;
private String price;
private LocalDate tarix;
private String nov;

public Book(Integer id,String name, String author, String price, LocalDate tarix, String nov) {
	this.id = id;
	this.name = name;
	this.author = author;
	this.price = price;
	this.tarix = tarix;
	this.nov = nov;
}
public Book() {
	
}
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getNov() {
	return nov;
}
public void setNov(String nov) {
	this.nov = nov;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public String getPrice() {
	return price;
}
public void setPrice(String price) {
	this.price = price;
}
public LocalDate getTarix() {
	return tarix;
}
public void setTarix(LocalDate tarix) {
	this.tarix = tarix;
}
}

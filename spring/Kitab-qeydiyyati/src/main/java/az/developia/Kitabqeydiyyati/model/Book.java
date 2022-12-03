package az.developia.Kitabqeydiyyati.model;

import java.sql.Date;

public class Book {
	private Integer id;
private String name;
private Integer price;
private Date printdate;
private String author;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Integer getPrice() {
	return price;
}
public void setPrice(Integer price) {
	this.price = price;
}
public Date getPrintdate() {
	return printdate;
}
public void setPrintdate(Date printdate) {
	this.printdate = printdate;
}
public String getAuthor() {
	return author;
}
public void setAuthor(String author) {
	this.author = author;
}
public Book(Integer id,String name, Integer price, Date printdate, String author) {
	super();
	this.id=id;
	this.name = name;
	this.price = price;
	this.printdate = printdate;
	this.author = author;
}
public Book() {
	
}

}

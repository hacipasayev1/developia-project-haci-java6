package az.developia.springmvcjdbc.model;

import java.sql.Date;
import java.time.LocalDate;

public class Student {
private Integer id;
private String name;
private String surname;
private String phone;
private String address;
private String email;
private Date birthday;
public Student(Integer id, String name, String surname, String phone, String address, String email, Date birthday,
		String sector) {
	super();
	this.id = id;
	this.name = name;
	this.surname = surname;
	this.phone = phone;
	this.address = address;
	this.email = email;
	this.birthday = birthday;
	this.sector = sector;
}
public Student() {
	
}
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
public String getSurname() {
	return surname;
}
public void setSurname(String surname) {
	this.surname = surname;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Date getBirthday() {
	return birthday;
}
public void setBirthday(Date birthday) {
	this.birthday = birthday;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
private String sector;
}

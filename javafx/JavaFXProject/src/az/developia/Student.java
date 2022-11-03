package az.developia;

import java.time.LocalDate;

public class Student {
private Integer id;
private String name;
private String surname;
private LocalDate birthday;
private String sector;
private String gender;
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
public Student(Integer id, String name, String surname, LocalDate birthday, String sector, String gender) {

	this.id = id;
	this.name = name;
	this.surname = surname;
	this.birthday = birthday;
	this.sector = sector;
	this.gender = gender;
}
public Student() {
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", surname=" + surname + ", birthday=" + birthday + ", sector="
			+ sector + ", gender=" + gender + "]";
}
public void setSurname(String surname) {
	this.surname = surname;
}
public LocalDate getBirthday() {
	return birthday;
}
public void setBirthday(LocalDate birthday) {
	this.birthday = birthday;
}
public String getSector() {
	return sector;
}
public void setSector(String sector) {
	this.sector = sector;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
}

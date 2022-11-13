package az.developia.spring.core;

import org.springframework.stereotype.Component;

@Component(value="telebe")
public class Student {
private int id;
private String name;
public int getId() {
	return id;
}
public Student() {
	id=34;
	name="Adil";
	System.out.println("buda subut");
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Student(int id, String name) {
	super();
	this.id = id;
	this.name = name;
}
@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + "]";
}
}

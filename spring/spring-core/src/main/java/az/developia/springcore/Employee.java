package az.developia.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Configuration
public class Employee {
private int id;

private String name;

private int age;
@Autowired(required=false)
private Computer computer;

public Employee() {
	id=12;
	name="Hesen";
	age=30;
}
public int getId() {
	return id;
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
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

@Bean
public Employee myEmployee() {
	Employee e1=new Employee();
	return e1;
}
@Override
public String toString() {
	return "Employee [id=" + id + ", name=" + name + ", age=" + age + ", computer=" + computer + "]";
}



}

package az.developia.springbeanscopes;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(scopeName="prototype")
public class Home {
int id;
String address;
String color;

@PostConstruct
public void init() {
	System.out.println("init");
}
@PreDestroy
public void destroy() {
	System.out.println("destroy");
}

public Home() {
	id=12;
	address="baki";
	color="green";
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getColor() {
	return color;
}
public void setColor(String color) {
	this.color = color;
}
}

package az.developia.springcore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component(value="telebe")
@Primary
public class Student {
	private int id;
	private String name;
	@Autowired
	@Qualifier(value="laptop1")
	private Laptop laptop;
	
	
	
	public Laptop getLaptop() {
		return laptop;
	}
	
	
	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}
	
	
	
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

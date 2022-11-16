package az.developia.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import az.developia.springcore.beans.Computer;

@Configuration
public class MyConfig {
	
	@Value(value="${companyName}")
	private String companyName;
	@Bean
public Student myStudent() {
	Student s=new Student();
	s.setId(122);
	s.setName("Eli");
	return s;
}
	
public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	//	@Bean
//public Student yourStudent() {
//	Student s=new Student();
//	s.setId(555);
//	s.setName("Araz");
//	return s;
//}
	@Bean
public Laptop myLaptop() {
	Laptop l=new Laptop();
	l.setPrice(1234);
	l.setModel("x6");
	return l;
}

	@Bean
	public Computer myComputer() {
		Computer l=new Computer();
		l.setBrand("hp");
		l.setPrice(1234);
		l.setColor("red");
		l.setId(432);
		return l;
	}
}

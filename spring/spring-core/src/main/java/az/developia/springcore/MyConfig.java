package az.developia.springcore;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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

}

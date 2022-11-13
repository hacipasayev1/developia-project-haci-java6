package az.developia.spring.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {



	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
	String[] names = context.getBeanDefinitionNames();
	for (String n : names) {
		//System.out.println(n);
	}
	Student s=context.getBean(Student.class);
	System.out.println(s);
	s.setName("Cavid");
	Student s2=context.getBean(Student.class);
	System.out.println(s2);
	}

}

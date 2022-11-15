package az.developia.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringCoreApplication {

	public static void main(String[] args) {
	ConfigurableApplicationContext context = SpringApplication.run(SpringCoreApplication.class, args);
	
	Student s=context.getBean(Student.class);
	System.out.println(s.getLaptop());
//	System.out.println(s.getLaptop());
	MyConfig c=context.getBean(MyConfig.class);
	System.out.println(c.getCompanyName());
	
	
	
	
	
	}

}

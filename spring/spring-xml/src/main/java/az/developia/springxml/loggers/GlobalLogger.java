package az.developia.springxml.loggers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile(value="product")
public class GlobalLogger implements MyLogger{

	@Override
	public void log(String log) {
System.out.println("GlobalLogger : "+log);		
	}

}

package az.developia.springxml;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import az.developia.springxml.loggers.MyLogger;
@Component
@Profile(value="develop")
public class LocalLogger implements MyLogger{

	@Override
	public void log(String log) {
		System.out.println("LocalLogger : "+log);		
		
	}

}

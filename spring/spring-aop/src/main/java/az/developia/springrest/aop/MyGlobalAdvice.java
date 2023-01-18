package az.developia.springrest.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.springrest.exceptions.MyValidationException;

@RestControllerAdvice
public class MyGlobalAdvice {
@ExceptionHandler
public List<String> handleMyValidationException(MyValidationException exc){
	BindingResult br=exc.getBr();
	ArrayList<String> errors=new ArrayList<>();
	for (FieldError e : br.getFieldErrors()) {
		errors.add(e.getField()+":::"+e.getDefaultMessage());
	}
	return errors;
}
}

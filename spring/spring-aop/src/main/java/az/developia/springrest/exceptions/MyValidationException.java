package az.developia.springrest.exceptions;

import org.springframework.validation.BindingResult;

import lombok.Data;
import lombok.Getter;
@Getter
public class MyValidationException extends RuntimeException {
private BindingResult br;
public MyValidationException(BindingResult br) {
	this.br=br;
}
}

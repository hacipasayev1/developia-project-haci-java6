package az.developia.MarketShopHaji.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import az.developia.MarketShopHaji.exc.IdFalseException;
import az.developia.MarketShopHaji.exc.NotFindedProductException;
import az.developia.MarketShopHaji.exc.UsernameAlreadyDefinedException;

@RestControllerAdvice
public class GlobalAdvice {
@ExceptionHandler
@ResponseStatus(code = HttpStatus.CONFLICT)
public String handleUsernameAlreadyDefinedException(UsernameAlreadyDefinedException exception) {
return exception.getMessage();
}

@ExceptionHandler
@ResponseStatus(code = HttpStatus.FORBIDDEN)
public String handleIdFalseException(IdFalseException exception) {
	return exception.getMessage();
}
@ExceptionHandler
public String handleNotFindedProductException(NotFindedProductException exception) {
	return exception.getMessage();
}

}

package pl.dn.exception.handler;

import javax.xml.bind.ValidationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ValidationException.class)
	public 	String handleValidationException(ValidationException ex) {
		return ex.getMessage();
	}
	
}

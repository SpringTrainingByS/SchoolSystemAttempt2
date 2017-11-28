package pl.dn.exception.handler;

import javax.xml.bind.ValidationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
@Component
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ValidationException.class})
	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	public 	ResponseEntity<String> handleValidationException(ValidationException ex) {
		
		ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("Przejê³em wyjatkêk: " + ex.getMessage());
		
		return response;
	}
	
}

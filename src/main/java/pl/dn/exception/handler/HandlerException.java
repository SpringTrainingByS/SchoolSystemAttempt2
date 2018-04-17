package pl.dn.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import io.jsonwebtoken.JwtException;
import pl.dn.exception.ValidationException;


@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ValidationException.class})
	@ResponseBody
	public 	ResponseEntity<String> handleValidationException(ValidationException ex) {
		
		ResponseEntity<String> response = new ResponseEntity<String>(ex.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
		System.out.println("Przeje³em wyjatêk: " + ex.getMessage());
		
		return response;
	}
}

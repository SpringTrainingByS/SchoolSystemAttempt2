package pl.dn.exception.handler;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import pl.dn.base.customModels.BaseDetailResponseConflict;
import pl.dn.exception.ValidationException;


@RestControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ValidationException.class})
	@ResponseBody
	public 	ResponseEntity<BaseDetailResponseConflict> handleValidationException(ValidationException ex) {
		
		BaseDetailResponseConflict responseConflict = new BaseDetailResponseConflict(ex.getMessage(), ex.getAddedElements());
		ResponseEntity<BaseDetailResponseConflict> response = new ResponseEntity<BaseDetailResponseConflict>(responseConflict, HttpStatus.CONFLICT);
		System.out.println("Przeje³em wyjatêk: " + ex.getMessage());
		
		return response;
	}
}

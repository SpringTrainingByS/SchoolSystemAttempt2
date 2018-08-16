package pl.dn.exception;

import java.util.List;

import pl.dn.base.BaseDetail;


public class ValidationException extends Exception {
	
	List<? extends BaseDetail> addedElements;
	
	public ValidationException(String message) {
		super(message);
	}

	public ValidationException(String message,List<? extends BaseDetail> addedElements) {
		super(message);
		this.addedElements = addedElements;
	}

	public List<? extends BaseDetail> getAddedElements() {
		return addedElements;
	}

}

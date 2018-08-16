package pl.dn.base.customModels;

import java.util.List;

import pl.dn.base.BaseDetail;

public class BaseDetailResponseConflict {
	
	private String message;
	private List<? extends BaseDetail> addedElements;
	
	public BaseDetailResponseConflict(String message, List<? extends BaseDetail> addedElements) {
		this.message = message;
		this.addedElements = addedElements;
	}

	public String getMessage() {
		return message;
	}

	public List<? extends BaseDetail> getAddedElements() {
		return addedElements;
	}
}

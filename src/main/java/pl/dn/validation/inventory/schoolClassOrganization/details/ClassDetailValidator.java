package pl.dn.validation.inventory.schoolClassOrganization.details;

import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.details.ClassDetailDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassDetail;

@Service
public class ClassDetailValidator {
	
	
	public void validateBeforeAdd(ClassDetail classDetail, ClassDetailDao dao) throws ValidationException{
		String messages = "";
		
		if (classDetail.getId() != 0) {
			messages += "Id jest niepoprawne.";
		}
		
		if (!classDetail.getName().matches("^[a-z]+$")) {
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {
			ClassDetail classDetail2 = dao.findByName(classDetail.getName());
			if (classDetail2 != null) {
				messages += "Nazwa instnieje ju¿ w bazie  (" + classDetail.getName() + ").";
			}
		}
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
		
	}
	
	public void validateBeforeUpdate(ClassDetail classDetailNew, ClassDetailDao dao ) throws ValidationException {
		String messages = "";
		
		if (classDetailNew.getId() == 0) {
			messages += "Id jest nieprawid³owe";
		}
		
		if (!classDetailNew.getName().matches("^[a-z]+$")) {
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {
			ClassDetail classDetail = dao.findByName(classDetailNew.getName());
			if (classDetail != null) {
				
				if (classDetailNew.getId() != classDetail.getId()) {
					messages += "Nazwa instnieje ju¿ w bazie (" + classDetailNew.getName() + ")";
				}
			}
		}
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
	}

}

package pl.dn.validation.inventory.schoolClassOrganization.details;

import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.details.ClassDetailDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.base.BaseDetail;

@Service
public class ClassDetailValidator {
	
	private String[] namePatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	public void validateBeforeAdd(BaseDetail classDetailNew, ClassDetailDao<?> dao) throws ValidationException{
		String messages = "";
		
		if (classDetailNew.getId() != 0) {
			messages += "Id jest niepoprawne.";
		}
		
		if (!checkValueByRegex(classDetailNew.getName(), namePatterns)) {
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {
			BaseDetail classDetailOld = dao.findByName(classDetailNew.getName());
			if (classDetailOld != null) {
				messages += "Nazwa instnieje ju¿ w bazie  (" + classDetailNew.getName() + ").";
			}
		}
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
		
	}
	
	public void validateBeforeUpdate(BaseDetail classDetailNew, ClassDetailDao<?> dao ) throws ValidationException {
		String messages = "";
		
		if (classDetailNew.getId() == 0) {
			messages += "Id jest nieprawid³owe";
		}
		
		if (!checkValueByRegex(classDetailNew.getName(), namePatterns)) {
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {
			BaseDetail classDetail = dao.findByName(classDetailNew.getName());
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
	
	public boolean checkValueByRegex(String value, String[] regexes) {
		boolean isCorrect = false;
		
		for (String regex : regexes) {
			//Pattern pattern = Pattern.compile(regex);
			//isCorrect = pattern.matcher(value).matches();
			isCorrect = value.matches(regex);
			//System.out.println("Dla " + value + " wyra¿enie " + regex + " daje " + isCorrect);
			if (isCorrect) break;
		}
		
		return isCorrect;
	}

}

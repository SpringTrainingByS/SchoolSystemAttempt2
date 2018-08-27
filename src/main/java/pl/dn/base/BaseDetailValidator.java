package pl.dn.base;

import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;

@Service
public class BaseDetailValidator {

	private static Logger logger = LoggerFactory.getLogger(BaseDetailValidator.class);
	
	public void validateBeforeAdd(BaseDetail detailNew, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException{
		String messages = "";
		
		if (detailNew.getId() != 0) {
			messages += "Id jest niepoprawne.";
		}
		
		if (!checkValueByRegex(detailNew.getName(), validationPatterns)) {
			System.out.println("Nazwa jest nieprawid³owa");
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {
			logger.info("BaseDetail.Name: " + detailNew.getName());
			System.out.println("BaseDetail.Name: " + detailNew.getName());
			BaseDetail classDetailOld = dao.findByName(detailNew.getName());
			if (classDetailOld != null) {
				logger.info("BaseDetail with name " + detailNew.getName() + " found in database.");
				messages += "Nazwa instnieje ju¿ w bazie  (" + detailNew.getName() + ").";
			}
			else {
				logger.info("BaseDetail with name " + detailNew.getName() + " not found in database");
			}
		}
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
		
	}
	
	public void validateBeforeUpdate(BaseDetail classDetailNew, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException {
		String messages = "";
		
		if (classDetailNew.getId() == 0) {
			messages += "Id jest nieprawid³owe";
		}
		
		if (!checkValueByRegex(classDetailNew.getName(), validationPatterns)) {
			messages += "Nazwa jest nieprawid³owa.";
		}
		else {

			BaseDetail classDetail = dao.findByName(classDetailNew.getName());
			if (classDetail != null) {
				messages += "Nazwa instnieje ju¿ w bazie (" + classDetailNew.getName() + ")";
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

package pl.dn.validation.inventory.schoolClassOrganization.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.details.ClassPrefixDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;

@Service
public class ClassPrefixValidator {
	
	@Autowired
	private ClassPrefixDao classPrefixDao;
	
	public void validateBeforeAdd(ClassPrefix classPrefix) throws ValidationException{
		String messages = "";
		
		if (classPrefix.getId() != 0) {
			messages += "Id dla prefiksu klasy zajêciowej jest niepoprawne.";
		}
		
		if (!classPrefix.getName().matches("^[a-z]+$")) {
			messages += "Nazwa dla prefiksu klasy jest nieprawid³owa.";
		}
		else {
			ClassPrefix classPrefix2 = classPrefixDao.findByName(classPrefix.getName());
			if (classPrefix2 != null) {
				messages += "Nazwa dla nowego prefiksu instnieje ju¿ w bazie.";
			}
		}
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
		
	}

}

package pl.dn.validation.inventory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.inventory.ClassroomTypeDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.inventory.ClassroomType;

@Service
public class ClassroomTypeValidatior {
	
	@Autowired
	private ClassroomTypeDao classroomTypeDao;
	
	
	public void validateBeforeAdd(ClassroomType classroomType) throws ValidationException {
		String messages = "";
		
		if (classroomType.getId() != 0) {
			messages += "Nieprawid³owe id.";
		}
		
		String name = classroomType.getName().trim();
		classroomType.setName(name);
		
		if (!classroomType.getName().matches("^[a-z]+$")) {
			messages += "Nieprawid³owa nazwa.";
		}
		
		ClassroomType classroomTypeExsisting = 
				classroomTypeDao.findByName(classroomType.getName());
		
		if (classroomTypeExsisting != null) {
			messages += "Typ klasy o podanej nazwie istnieje";
		}
		
		if (messages != "") {
			throw new ValidationException(messages);
		}
		
	}
	
}

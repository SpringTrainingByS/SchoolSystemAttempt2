package pl.dn.inventory.classroomType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;

@Service
public class ClassroomTypeValidator {
	
	@Autowired
	private ClassroomTypeDao classroomTypeDao;
	
	
	public void validateBeforeAdd(ClassroomType classroomType) throws ValidationException {
		String messages = "";
		
		if (classroomType.getId() != 0) {
			messages += "Nieprawid³owe id dla typu sali klasowej.";
		}
		
		messages += checkNameAndExistence(classroomType);
		
		System.out.println("messages: " + messages);
		
		if (!messages.isEmpty()) {
			System.out.println("Wyrzucam wyj¹tek ValidationException");
			throw new ValidationException(messages);
		}
		
	}
	
	public void validateBeforeUpdate(ClassroomType classroomType) throws ValidationException {
		
		String messages = "";
		
		if (classroomType.getId() == 0) {
			messages += "Brak id dla typu sali klasowej.";
		}
		
		messages += checkNameAndExistence(classroomType);
		
		if (!messages.isEmpty()) {
			throw new ValidationException(messages);
		}
		
	}
	
	
	public String checkNameAndExistence(ClassroomType classroomType) {
		String messages = "";
		
		String name = classroomType.getName().trim();
		classroomType.setName(name);
		
		if (!classroomType.getName().matches("^[a-z]+[-]*[a-z]*$")) {
			messages += "Nieprawid³owa nazwa dla typu sali klasowej.";
		}
		
		ClassroomType classroomTypeExsisting = 
				classroomTypeDao.findByName(classroomType.getName());
		
		if (classroomTypeExsisting != null) {
			messages += "Typ sali klasowej o podanej nazwie ju¿ istnieje";
		}
		
		return messages;
	}
	
	public String checkCompatiblityClassroomType(ClassroomType classroomType) {
		String messages = "";
		
		ClassroomType classroomType2 = classroomTypeDao.findById(classroomType.getId());
		
		if (classroomType2 == null) {
			messages += "Brak wybranego typu klasy w bazie.";
		}
		else if (!classroomType2.getName().equals(classroomType.getName())) {
			System.out.println("Nazwa1: +" + classroomType.getName() + "+");
			System.out.println("Nazwa2: +" + classroomType2.getName() + "+");
			messages += "Typ sali klasowej nie zgadza siê z bazowym.";
		}
		
		return messages;
	}
	
}

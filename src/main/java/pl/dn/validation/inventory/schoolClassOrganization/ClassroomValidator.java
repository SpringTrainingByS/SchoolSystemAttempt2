package pl.dn.validation.inventory.schoolClassOrganization;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.inventory.ClassroomDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.inventory.Classroom;
import pl.dn.validation.inventory.schoolClassOrganization.details.ClassroomTypeValidator;

@Service
public class ClassroomValidator {
	
	@Autowired
	private ClassroomDao classroomDao;
	
	@Autowired
	private ClassroomTypeValidator classroomTypeValidatior;
	
	public void validateBeforeAdd(Classroom classroom) throws ValidationException {
		String messages = "";
		
		if (classroom.getId() != 0) {
			messages += "Nieprawid³owe id dla sali klasowej.";
		}
		
		messages += checkClassroomNumberForAdd(classroom.getNumber());
	
		
		if (!Integer.toString(classroom.getNumberOfPeople()).matches("^[0-9]+$")) {
			messages += "Nieprawdi³owa wartoœæ pojemnoœci sali klasowej";
		}
		
		messages += classroomTypeValidatior.checkCompatiblityClassroomType(classroom.getType());
		
		if (!messages.isEmpty()) {
			System.out.println("Wyrzucam wyj¹tek");
			throw new ValidationException(messages);
		}
	
	}
	
	public void validateBeforeUpdate(Classroom classroom) throws ValidationException {
		String messages = "";
		
		if (!Long.toString(classroom.getId()).matches("^[0-9]$") ) {
			messages += "Id sali klasowej jest zdefiniowane w nieprawid³owej formie.";
		}
		
		messages = checkClassroomNumberForUpdate(messages, classroom.getId());
		
		if (!Integer.toString(classroom.getNumberOfPeople()).matches("^[0-9]+$")) {
			messages += "Nieprawdi³owa wartoœæ pojemnoœci sali klasowej";
		}
		
		messages += classroomTypeValidatior.checkCompatiblityClassroomType(classroom.getType());
		
		if (!messages.isEmpty()) {
			System.out.println("Wyrzucam wyj¹tek");
			throw new ValidationException(messages);
		}
		
		
	}
	
	public String checkClassroomNumberForAdd(String classroomNr) {
		String messages = "";
		
		if (!classroomNr.matches("^[0-9]+[a-z]*$")) {
			messages += "Nie prawid³owy nr sali klasowej";
		}
		else {
			Classroom classroom2 = classroomDao.findByNumber(classroomNr);
			if (classroom2 != null) {
				messages += "Sala klasowa o podanym numerze ju¿ istnieje.";
			}
		}
		
		return messages;
	}
	
	
	public String checkClassroomNumberForUpdate(String classroomNr, Long actualId) {
		String messages = "";
		
		if (!classroomNr.matches("^[0-9]+[a-z]*$")) {
			messages += "Nie prawid³owy nr sali klasowej";
		}
		else {
			Classroom classroom2 = classroomDao.findByNumber(classroomNr);
			if (classroom2 != null) {
				if (actualId != classroom2.getId()) {
					messages += "Sala klasowa o podanym numerze ju¿ istnieje.";
				}
			}
		}
		
		return messages;
	}
	
	
}

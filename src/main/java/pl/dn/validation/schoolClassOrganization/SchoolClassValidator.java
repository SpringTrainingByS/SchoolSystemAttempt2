package pl.dn.validation.schoolClassOrganization;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.SchoolClassDao;
import pl.dn.dao.schoolClassOrganization.details.ClassPrefixDao;
import pl.dn.dao.schoolClassOrganization.details.ClassSpecializationDao;
import pl.dn.dao.schoolClassOrganization.details.ClassTypeDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.SchoolClass;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.model.schoolClassOrganization.details.ClassSpecialization;
import pl.dn.model.schoolClassOrganization.details.ClassType;

@Service
public class SchoolClassValidator {
	
	@Autowired
	private ClassSpecializationDao specializationDao;
	
	@Autowired
	private ClassTypeDao typeDao;
	
	@Autowired
	private ClassPrefixDao prefixDao;
	
	@Autowired 
	private SchoolClassDao schoolClassDao;
	
	private String[] namePatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	public void validateBeforeAdd(SchoolClass schoolClass) throws ValidationException {
		String message = "";
		
		if (schoolClass == null) {
			message = "Jednostka nie mo¿e byæ pusta.";
		}
		else {
			
			message += checkFieldsAreNull(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += validateIdsForAdd(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += checkEntityFieldsValues(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += validateIntegrityDb(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += checkDuplicateEntityByPrefix(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
		}
	}
	
	public void validateBeforeUpdate(SchoolClass schoolClass) throws ValidationException {
		String message = "";
		
		if (schoolClass == null) {
			message = "Jednostka nie mo¿e byæ pusta.";
		}
		else {
			
			message += checkFieldsAreNull(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += validateIdsForUpdate(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += checkEntityFieldsValues(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
			message += validateIntegrityDb(schoolClass);
			if (!message.isEmpty()) {
				throw new ValidationException(message);
			}
			
		}
	}
	
	private String checkFieldsAreNull(SchoolClass schoolClass) {
		String message = "";
		
		if (schoolClass.getPrefix() == null) {
			message += "Klasa powinna posiadaæ prefiks."; 
		}
		
		if (schoolClass.getClassSpecializationList() == null) {
			message += "Klasa powinna posiadaæ jedn¹ specjalizacjê.";
		}
		
		if (schoolClass.getType() == null) {
			message += "Klasa powinna posiadaæ typ.";
		}
		
		return message;
	}
	
	private String validateIdsForAdd(SchoolClass schoolClass) {
		String message = "";
		
		if (schoolClass.getId() != 0) {
			message += "Nieprawid³owe id dla klasy.";
		}
		if (schoolClass.getPrefix().getId() == 0) {
			message += "Nieprawid³owe id dla prefiksu.";
		}
		if (schoolClass.getType().getId() == 0) {
			message += "Nieprawid³owe id dla typu klasy.";
		}
		
		for (ClassSpecialization specialization : schoolClass.getClassSpecializationList()) {
			if (specialization.getId() == 0) {
				message += "Nieprawid³owe id dla specjalizacji: " + specialization.getName() + ".";
			}
		}
		
		return message;
	}
	
	public String validateIdsForUpdate(SchoolClass schoolClass) {
		String message = "";
		
		if (schoolClass.getId() == 0) {
			message += "Nieprawid³owe id dla klasy.";
		}
		if (schoolClass.getPrefix().getId() == 0) {
			message += "Nieprawid³owe id dla prefiksu.";
		}
		if (schoolClass.getType().getId() == 0) {
			message += "Nieprawid³owe id dla typu klasy.";
		}
		
		for (ClassSpecialization specialization : schoolClass.getClassSpecializationList()) {
			if (specialization.getId() == 0) {
				message += "Nieprawid³owe id dla specjalizacji: " + specialization.getName() + ".";
			}
		}
		
		return message;
	}
	
	private String checkEntityFieldsValues(SchoolClass schoolClass) {
		String message = "";
		
		if (!checkValueByRegex(schoolClass.getPrefix().getName(), namePatterns)) {
			message += "Nieprawdi³owa nazwa dla prefiksu.";
		}
		
		if (!checkValueByRegex(schoolClass.getType().getName(), namePatterns)) {
			message += "Nieprawdi³owa nazwa dla typu klasy.";
		}
		
		for (ClassSpecialization specialization : schoolClass.getClassSpecializationList()) {
			if (!checkValueByRegex(specialization.getName(), namePatterns)) {
				message += "Nieprawid³owe nazwa dla specjalizacji: " + specialization.getName() + ".";
			}
		}
		
		return message;
	}
	
	private String validateIntegrityDb(SchoolClass schoolClass) throws ValidationException {
		String message = "";
		
		for (ClassSpecialization specialization : schoolClass.getClassSpecializationList()) {
			ClassSpecialization specializationDb = specializationDao.findById(specialization.getId());
			if (specializationDb == null) {
				message += "Specjalizacja " + specialization.getName() + " nie istnieje w bazie.";
				break;
			}
			else if (!specializationDb.getName().equals(specialization.getName())) {
				message += "Specjalizacja " + specialization.getName() + " jest niezgodna z odpowiednikiem w bazie.";
				break;
			}
		
		}
		
		ClassType typeDb = typeDao.findById(schoolClass.getType().getId());
		
		if (typeDb == null) {
			message += "Brak typu klasy w bazie.";
		}
		else if (!typeDb.getName().equals(schoolClass.getType().getName())) {
			message += "Typ " + schoolClass.getType().getName() + " jest niezgodna z odpowiednikiem w bazie.";
		}
		
		ClassPrefix classPrefix = prefixDao.findById(schoolClass.getPrefix().getId());
		
		if (classPrefix == null) {
			message += "Brak prefix klasy w bazie.";
		}
		else if (!classPrefix.getName().equals(schoolClass.getPrefix().getName())) {
			message += "Prefiks: " + schoolClass.getType().getName() + " jest niezgodna z odpowiednikiem w bazie.";
		}
		
		if (!message.isEmpty()) {
			throw new ValidationException(message);
		}
	
		return message;
	}
	
	public String checkDuplicateEntityByPrefix(SchoolClass schoolClass) {
		//System.out.println("Sprawdzam duplikaty");
		String message = "";
		
		long prefixId = schoolClass.getPrefix().getId();
		List<SchoolClass> schoolClassDbGroup = schoolClassDao.findByPrefixId(prefixId);
		
		int year = Calendar.getInstance().get(Calendar.YEAR);
		int schoolClassYear = 0;
		
		for (SchoolClass schoolClassDb : schoolClassDbGroup) {
			
			schoolClassYear = schoolClassDb.getStartDate().get(Calendar.YEAR); 
			if (schoolClassYear == year) {
				message += "Wykryto istniej¹c¹ klasê o takim samym roku rozpoczêcia i prefiksie";
				break;
			}
			
		}
		
		return message;
	}
	
	public boolean checkValueByRegex(String value, String[] regexes) {
		boolean isCorrect = false;
		
		for (String regex : regexes) {
			isCorrect = value.matches(regex);
			if (isCorrect) break;
		}
		
		return isCorrect;
	}

}

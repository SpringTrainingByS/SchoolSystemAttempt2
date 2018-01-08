package pl.dn.controller.schoolClassOrganization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.dao.schoolClassOrganization.SchoolClassDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.SchoolClass;
import pl.dn.service.schoolClassOrganization.SchoolClassService;

@RestController
@RequestMapping(value = "schoolclass")
public class SchoolClassController {

	@Autowired
	private SchoolClassService service;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody SchoolClass schoolClass) throws ValidationException {
		service.add(schoolClass);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public SchoolClass getById(@PathVariable long id) {
		return service.getById(id);
	}
	
	
	
}

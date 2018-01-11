package pl.dn.controller.schoolClassOrganization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.dao.schoolClassOrganization.SchoolSubjectDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.SchoolSubject;
import pl.dn.service.base.BaseDetailService;

@RestController
@RequestMapping(value = "school-subject")
public class SchoolSubjectController {

	@Autowired
	private BaseDetailService service;
	
	@Autowired
	private SchoolSubjectDao dao;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody SchoolSubject schoolSubject) throws ValidationException {
		service.add(schoolSubject, dao, validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<SchoolSubject> schoolSubjectGroup) throws ValidationException {
		service.addSet(schoolSubjectGroup, dao, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public SchoolSubject get(@PathVariable long id) {
		return (SchoolSubject) service.getById(id, dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<SchoolSubject> getAll() {
		return (List<SchoolSubject>) service.getAll(dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<SchoolSubject> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<SchoolSubject>) service.getByPagination(limit, offset, dao);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody SchoolSubject schoolSubject) throws ValidationException{
		service.update(schoolSubject, dao, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		service.deleteById(id, dao);
	}
}

package pl.dn.schoolClassOrganization.schoolSubject;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.base.BaseDetailService;
import pl.dn.exception.ValidationException;

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
		service.add(schoolSubject, null, validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<SchoolSubject> schoolSubjectGroup) throws ValidationException {
		service.addSet(schoolSubjectGroup, null, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public SchoolSubject get(@PathVariable long id) {
		return (SchoolSubject) dao.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<SchoolSubject> getAll() {
		return (List<SchoolSubject>) dao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<SchoolSubject> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<SchoolSubject>) dao.findUsePagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody SchoolSubject schoolSubject) throws ValidationException{
		service.update(schoolSubject, null, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dao.findById(id);
	}
}

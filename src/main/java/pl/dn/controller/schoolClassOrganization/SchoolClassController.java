package pl.dn.controller.schoolClassOrganization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.exception.ValidationException;
import pl.dn.schoolClassOrganization.schoolClass.SchoolClass;
import pl.dn.schoolClassOrganization.schoolClass.SchoolClassDao;
import pl.dn.schoolClassOrganization.schoolClass.SchoolClassService;

@RestController
@RequestMapping(value = "schoolclass")
public class SchoolClassController {

	@Autowired
	private SchoolClassService service;
	
	@Autowired
	private SchoolClassDao dao;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody SchoolClass schoolClass) throws ValidationException {
		service.add(schoolClass);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public SchoolClass getById(@PathVariable long id) {
		return dao.findById(id);
	}
	
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<SchoolClass> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return dao.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<SchoolClass> getAll() {
		return dao.findAll();
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody SchoolClass schoolClass) throws ValidationException {
		service.update(schoolClass);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable long id) {
		dao.findById(id);
	}
	
	
}

package pl.dn.controller.schoolClassOrganization.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.dao.schoolClassOrganization.details.ClassSpecializationDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.BaseDetail;
import pl.dn.model.schoolClassOrganization.details.ClassSpecialization;
import pl.dn.service.schoolClassOrganization.details.ClassDetailService;

@RestController
@RequestMapping(value = "class-spec")
public class ClassSpecializationController {
	
	@Autowired
	private ClassDetailService classDetailService;
	
	@Autowired
	private ClassSpecializationDao dao;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassSpecialization classSpecialization) throws ValidationException {
		classDetailService.add(classSpecialization, dao);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<ClassSpecialization> classSpecializationGroup) throws ValidationException {
		classDetailService.addSet(classSpecializationGroup, dao);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassSpecialization get(@PathVariable long id) {
		return (ClassSpecialization) classDetailService.getById(id, dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassSpecialization> getAll() {
		return (List<ClassSpecialization>) classDetailService.getAll(dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassSpecialization> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassSpecialization>) classDetailService.getByPagination(limit, offset, dao);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassSpecialization classSpecialization) throws ValidationException{
		classDetailService.update(classSpecialization, dao);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classDetailService.deleteById(id, dao);
	}

}

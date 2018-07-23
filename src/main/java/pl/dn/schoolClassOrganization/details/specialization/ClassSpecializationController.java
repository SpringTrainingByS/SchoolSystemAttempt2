package pl.dn.schoolClassOrganization.details.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.base.BaseDetail;
import pl.dn.base.BaseDetailService;
import pl.dn.exception.ValidationException;

@RestController
@RequestMapping(value = "class-spec")
public class ClassSpecializationController {
	
	@Autowired
	private BaseDetailService classDetailService;
	
	@Autowired
	private ClassSpecializationDao dao;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassSpecialization classSpecialization) throws ValidationException {
		classDetailService.add(classSpecialization, dao, validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<ClassSpecialization> classSpecializationGroup) throws ValidationException {
		classDetailService.addSet(classSpecializationGroup, dao, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassSpecialization get(@PathVariable long id) {
		return (ClassSpecialization) dao.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassSpecialization> getAll() {
		return (List<ClassSpecialization>) dao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassSpecialization> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassSpecialization>) dao.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassSpecialization classSpecialization) throws ValidationException{
		classDetailService.update(classSpecialization, dao, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dao.deleteById(id);
	}

}

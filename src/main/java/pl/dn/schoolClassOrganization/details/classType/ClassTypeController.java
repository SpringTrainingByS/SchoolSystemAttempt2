package pl.dn.schoolClassOrganization.details.classType;

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
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

@RestController
@RequestMapping(value = "class-type")
public class ClassTypeController {

	@Autowired
	private BaseDetailService classDetailService;
	
	@Autowired
	private ClassTypeDao dao;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassType classType) throws ValidationException {
		classDetailService.add(classType, new ClassPrefixRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<ClassType> classTypeGroup) throws ValidationException {
		classDetailService.addSet(classTypeGroup, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassType get(@PathVariable long id) {
		return (ClassType) dao.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassType> getAll() {
		return (List<ClassType>) dao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassType> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassType>) dao.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassType classType) throws ValidationException{
		System.out.println("Id dla prefiksu: " + classType.getId());
		classDetailService.update(classType, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dao.deleteById(id);
	}
	
}

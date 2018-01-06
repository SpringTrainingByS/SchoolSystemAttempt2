package pl.dn.controller.schoolClassOrganization.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.dao.schoolClassOrganization.details.ClassTypeDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassType;
import pl.dn.service.schoolClassOrganization.details.ClassDetailService;

@RestController
@RequestMapping(value = "class-type")
public class ClassTypeController {

	@Autowired
	private ClassDetailService classDetailService;
	
	@Autowired
	private ClassTypeDao dao;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassType classType) throws ValidationException {
		classDetailService.add(classType, dao);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<ClassType> classTypeGroup) throws ValidationException {
		classDetailService.addSet(classTypeGroup, dao);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassType get(@PathVariable long id) {
		return (ClassType) classDetailService.getById(id, dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassType> getAll() {
		return (List<ClassType>) classDetailService.getAll(dao);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassType> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassType>) classDetailService.getByPagination(limit, offset, dao);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassType classType) throws ValidationException{
		System.out.println("Id dla prefiksu: " + classType.getId());
		classDetailService.update(classType, dao);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classDetailService.deleteById(id, dao);
	}
	
}

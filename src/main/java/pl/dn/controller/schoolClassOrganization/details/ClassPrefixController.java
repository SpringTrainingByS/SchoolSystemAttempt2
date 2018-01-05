package pl.dn.controller.schoolClassOrganization.details;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.dao.schoolClassOrganization.details.ClassPrefixDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassDetail;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.service.schoolClassOrganization.details.ClassDetailService;

@RestController
@RequestMapping(value = "class-prefixex")
public class ClassPrefixController {
	
	@Autowired
	private ClassDetailService classDetailService;
	
	@Autowired
	private ClassPrefixDao dao;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassPrefix classPrefix) throws ValidationException {
		classDetailService.add(classPrefix, dao);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<ClassPrefix> classPrefixGroup) throws ValidationException {
		classDetailService.addSet(classPrefixGroup, dao);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassPrefix get(@PathVariable long id) {
		return (ClassPrefix) classDetailService.getById(id, dao);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassDetail> getAll() {
		return classDetailService.getAll(dao);
	}
	
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassDetail> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return classDetailService.getByPagination(limit, offset, dao);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassPrefix classPrefix) throws ValidationException{
		System.out.println("Id dla prefiksu: " + classPrefix.getId());
		classDetailService.update(classPrefix, dao);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classDetailService.deleteById(id, dao);
	}
	
	

}

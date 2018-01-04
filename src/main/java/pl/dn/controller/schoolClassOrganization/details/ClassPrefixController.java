package pl.dn.controller.schoolClassOrganization.details;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.service.schoolClassOrganization.details.ClassPrefixService;

@RestController
@RequestMapping(value = "class-prefixex")
public class ClassPrefixController {
	
	@Autowired
	private ClassPrefixService classPrefixService;
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassPrefix classPrefix) throws ValidationException {
		classPrefixService.add(classPrefix);
	}
	
	public void addSet() {}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassPrefix get(@PathVariable long id) {
		return classPrefixService.getById(id);
	}
	
	public void getAll() {}
	
	public void getByPagination() {}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassPrefix classPrefix) throws ValidationException{
		System.out.println("Id dla prefiksu: " + classPrefix.getId());
		classPrefixService.update(classPrefix);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classPrefixService.deleteById(id);
	}
	
	

}

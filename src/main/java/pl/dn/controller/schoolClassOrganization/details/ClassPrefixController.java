package pl.dn.controller.schoolClassOrganization.details;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	public void get() {}
	
	public void getAll() {}
	
	public void getByPagination() {}
	
	public void update() {}
	
	public void delete() {}
	
	

}

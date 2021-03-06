package pl.dn.inventory.classroomType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.exception.ValidationException;
	
@RestController
@RequestMapping(value = "classroomtypes")
public class ClassroomTypeController {
	
	@Autowired
	private ClassroomTypeService classroomTypeService;
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassroomType classroomType) throws ValidationException, Exception {
		classroomTypeService.add(classroomType);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET) 
	public ClassroomType get(@PathVariable long id) {
		return classroomTypeService.get(id);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassroomType> getAll() {
		return classroomTypeService.getAll();
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassroomType classroomType) throws ValidationException {
		classroomTypeService.udpate(classroomType);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classroomTypeService.delete(id);
	}
	
}

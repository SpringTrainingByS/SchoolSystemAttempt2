package pl.dn.controller.inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.exception.ValidationException;
import pl.dn.model.inventory.ClassroomType;
import pl.dn.service.inventory.ClassroomTypeService;
	
@RestController
@RequestMapping(value = "classroomtypes")
public class ClassroomTypeController {
	
	@Autowired
	private ClassroomTypeService classroomTypeService;
	
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassroomType classroomType) throws ValidationException, Exception {
		//throw new Exception("Testujemy dalej");
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
	public void update(@RequestBody ClassroomType classroomType) {
		classroomTypeService.udpate(classroomType);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classroomTypeService.delete(id);
	}
	
}

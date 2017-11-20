package pl.dn.controller.inventory;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.model.inventory.ClassroomType;

@RestController
@RequestMapping(value = "classroomtypes")
public class ClassroomTypeController {
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody ClassroomType classroomType) {
		
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassroomType get(@PathVariable long id) {
		return null;
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassroomType> getAll() {
		return null;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassroomType classroomType) {
		
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		
	}
	
}

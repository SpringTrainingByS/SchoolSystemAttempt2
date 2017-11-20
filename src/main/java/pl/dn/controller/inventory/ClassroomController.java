package pl.dn.controller.inventory;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.model.inventory.Classroom;

@RestController
@RequestMapping(value = "classrooms")
public class ClassroomController {

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody Classroom classroom) {
		// miejsce na serwis
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Classroom get(@PathVariable long id) {
		// miejsce na serwis dodajacy
		return null;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody Classroom classrom) {
		// serwis
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		// serwis
	}
	
}

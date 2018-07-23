package pl.dn.inventory.classroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.exception.ValidationException;

@RestController
@RequestMapping(value = "classrooms")
public class ClassroomController {
	
	@Autowired 
	private ClassroomService classroomService;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody Classroom classroom) throws ValidationException {
		classroomService.add(classroom);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public Classroom get(@PathVariable long id) {
		return classroomService.getById(id);
	}
	
	@RequestMapping(value = "get", params="number", method = RequestMethod.GET)
	public Classroom getByNumer(@RequestParam String number) {
		return classroomService.getByNumber(number);
	}
	
	@RequestMapping(value = "get", params={"limit", "offset"}, method = RequestMethod.GET)
	public List<Classroom> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return classroomService.getByPagination(limit, offset);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<Classroom> getAll() {
		return classroomService.getAll();
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody Classroom classroom) throws ValidationException {
		classroomService.update(classroom);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classroomService.deleteById(id);
	}
	
}

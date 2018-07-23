package pl.dn.schoolClassOrganization.occupationalGroup;

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
@RequestMapping(value = "occupational-group")
public class OccupationalGroupController {
	
	@Autowired
	private OccupationalGroupService service;
	
	@Autowired
	private OccupationalGroupDao dao;

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody OccupationalGroup occupationalGroup) throws ValidationException {
		service.add(occupationalGroup);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public OccupationalGroup getById(@PathVariable long id) {
		return dao.findById(id);
	}
	
	@RequestMapping(value = "get", params = {"schoolclass-id"} , method = RequestMethod.GET)
	public List<OccupationalGroup> getBySchoolClassId(@RequestParam("schoolclass-id") long id) {
		return dao.findBySchoolClassId(id);
	}
	
	@RequestMapping(value = "get", params = {"teacher-id"} , method = RequestMethod.GET)
	public List<OccupationalGroup> getByTeacherId(@RequestParam("teacher-id") long id) {
		return dao.findByTeacherId(id);
	}
	
	@RequestMapping(value = "get", params = {"schoolclass-id", "teacher-id"} , method = RequestMethod.GET)
	public List<OccupationalGroup> getBySchoolClassIdAndTeacherId
		(@RequestParam("schoolclass-id") long schoolClassId, @RequestParam("teacher-id") long teacherId) {
		return dao.findBySchoolClassIdAndTeacherId(schoolClassId, teacherId);
	}
	
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<OccupationalGroup> getAll() {
		return dao.findAll();
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody OccupationalGroup occupationalGroup) throws ValidationException {
		service.update(occupationalGroup);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void deleteById(@PathVariable long id) {
		dao.deleteById(id);
	}
	
}

package pl.dn.schoolClassOrganization.details.specialization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.base.BaseDetailService;
import pl.dn.base.history.BaseDetailHistoryService;
import pl.dn.exception.ValidationException;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;
import pl.dn.schoolClassOrganization.details.specialization.history.ClassSpecializationRegistry;

@RestController
@RequestMapping(value = "class-specialization")
public class ClassSpecializationController {

	private BaseDetailService detailService;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};

	@Autowired
	public ClassSpecializationController(BaseDetailService detailService, ClassSpecializationDao sDao,
								 BaseDetailHistoryService<ClassSpecialization, ClassSpecializationRegistry> bdhService) {

		this.detailService = detailService;
		this.detailService.setBaseDetailDao(sDao);
		bdhService.setBaseDetailDao(sDao);
		this.detailService.setBdhService(bdhService);

	}

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ClassSpecialization add(@RequestBody ClassSpecialization classSpecialization) throws ValidationException {
		return (ClassSpecialization) detailService.add(classSpecialization, new ClassSpecializationRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public List<ClassSpecialization> addSet(@RequestBody List<ClassSpecialization> classSpecializationGroup) throws ValidationException {
		return (List<ClassSpecialization>) detailService.addSet(classSpecializationGroup, new ClassSpecializationRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassSpecialization get(@PathVariable long id) {
		return (ClassSpecialization) detailService.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassSpecialization> getAll() {
		return (List<ClassSpecialization>) detailService.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassSpecialization> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassSpecialization>) detailService.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassSpecialization classSpecialization) throws ValidationException{
		detailService.update(classSpecialization, new ClassSpecializationRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		detailService.deleteById(id);
	}

    @RequestMapping(value = "find", method = RequestMethod.POST)
    public List<ClassSpecialization> find(@RequestBody List<String> keyWords) {
        return  (List<ClassSpecialization>) detailService.find(keyWords);
    }

}

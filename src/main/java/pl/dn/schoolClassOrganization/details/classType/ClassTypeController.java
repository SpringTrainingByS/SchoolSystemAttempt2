package pl.dn.schoolClassOrganization.details.classType;

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
import pl.dn.schoolClassOrganization.details.classType.history.ClassTypeRegistry;


@RestController
@RequestMapping(value = "class-type")
public class ClassTypeController {


	private BaseDetailService detailService;


	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};

	@Autowired
	public ClassTypeController(BaseDetailService detailService, ClassTypeDao classTypeDao,
                               BaseDetailHistoryService<ClassType, ClassTypeRegistry> bdhService) {
		this.detailService = detailService;
		this.detailService.setBaseDetailDao(classTypeDao);
		bdhService.setBaseDetailDao(classTypeDao);
		this.detailService.setBdhService(bdhService);
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ClassType add(@RequestBody ClassType classType) throws ValidationException {
		return (ClassType) detailService.add(classType, new ClassTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public List<ClassType> addSet(@RequestBody List<ClassType> classTypeGroup) throws ValidationException {
		return (List<ClassType>) detailService.addSet(classTypeGroup, new ClassTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassType get(@PathVariable long id) {
	    return (ClassType) detailService.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassType> getAll() {
		return (List<ClassType>) detailService.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassType> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassType>) detailService.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassType classType) throws ValidationException{
		detailService.update(classType, new ClassTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		detailService.deleteById(id);
	}

    @RequestMapping(value = "find", method = RequestMethod.POST)
    public List<ClassType> find(@RequestBody List<String> keyWords) {

	    System.out.println("KeyWords: ");
	    for (String keyWord : keyWords) {
	        System.out.println("%" + keyWord + "%");
        }

        return  (List<ClassType>) detailService.find(keyWords);
    }
	
}

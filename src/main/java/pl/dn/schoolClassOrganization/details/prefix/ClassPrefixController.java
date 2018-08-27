package pl.dn.schoolClassOrganization.details.prefix;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistryDao;

@RestController
@RequestMapping(value = "class-prefixex")
public class ClassPrefixController {
	
	private BaseDetailService classDetailService;
	
	private String[] validationPatterns = {
	"^[\\p{L}]+$"};

	@Autowired
	public ClassPrefixController(BaseDetailService classDetailService, ClassPrefixDao classPrefixDao, 
			BaseDetailHistoryService<ClassPrefix, ClassPrefixRegistry> bdhService) {
		
		this.classDetailService = classDetailService;
		this.classDetailService.setBaseDetailDao(classPrefixDao);
		bdhService.setBaseDetailDao(classPrefixDao);
		this.classDetailService.setBdhService(bdhService);
		
	}

	@RequestMapping(value = "add", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public ClassPrefix add(@RequestBody ClassPrefix classPrefix, HttpServletRequest request) throws ValidationException {
		return (ClassPrefix) classDetailService.add(classPrefix, new ClassPrefixRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public List<ClassPrefix> addSet(@RequestBody List<ClassPrefix> classPrefixGroup) throws ValidationException {
		System.out.println();
		return (List<ClassPrefix>) classDetailService.addSet(classPrefixGroup, new ClassPrefixRegistry() , validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassPrefix get(@PathVariable long id) {
		return (ClassPrefix) classDetailService.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassPrefix> getAll() {
		return (List<ClassPrefix>) classDetailService.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassPrefix> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassPrefix>) classDetailService.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public void update(@RequestBody ClassPrefix classPrefix) throws ValidationException {
		classDetailService.update(classPrefix, new ClassPrefixRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		classDetailService.deleteById(id);
	}
	
	@RequestMapping(value = "count", method = RequestMethod.GET)
	public long count() {
		return classDetailService.count();
	}

	@RequestMapping(value = "find", method = RequestMethod.POST)
	public List<ClassPrefix> find(@RequestBody List<String> keyWords) {
		return  (List<ClassPrefix>) classDetailService.find(keyWords);
	}
}

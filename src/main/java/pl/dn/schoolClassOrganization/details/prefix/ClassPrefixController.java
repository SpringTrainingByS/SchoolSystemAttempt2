package pl.dn.schoolClassOrganization.details.prefix;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.base.BaseDetail;
import pl.dn.base.BaseDetailService;
import pl.dn.exception.ValidationException;

@RestController
@RequestMapping(value = "class-prefixex")
public class ClassPrefixController {
	
	@Autowired
	private BaseDetailService classDetailService;
	
	@Autowired
	private ClassPrefixDao dao;
	
	private String[] validationPatterns = {
	"^[\\p{L}]+$"};
	
	@RequestMapping(value = "add", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public void add(@RequestBody ClassPrefix classPrefix) throws ValidationException {
		classDetailService.add(classPrefix, dao, validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST, produces="application/json;charset=UTF-8")
	public void addSet(@RequestBody List<ClassPrefix> classPrefixGroup) throws ValidationException {
		System.out.println();
		classDetailService.addSet(classPrefixGroup, dao, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public ClassPrefix get(@PathVariable long id) {
		return (ClassPrefix) dao.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<ClassPrefix> getAll() {
		System.out.println("Pobieram wszystkie prefiksy ======================================================================================");
		return (List<ClassPrefix>) dao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<ClassPrefix> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<ClassPrefix>) dao.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody ClassPrefix classPrefix) throws ValidationException{
		System.out.println("Id dla prefiksu: " + classPrefix.getId());
		classDetailService.update(classPrefix, dao, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dao.deleteById(id);
	}
	
}

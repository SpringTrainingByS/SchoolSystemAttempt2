package pl.dn.schoolClassOrganization.details.creditType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.base.BaseDetailService;
import pl.dn.exception.ValidationException;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

@RestController
@RequestMapping(value = "credit-type")
public class CreditTypeController {

	@Autowired
	private BaseDetailService service;
	
	@Autowired
	private CreditTypeDao dao;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody CreditType creditType) throws ValidationException {
		service.add(creditType, new ClassPrefixRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<CreditType> creditType) throws ValidationException {
		service.addSet(creditType, validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public CreditType get(@PathVariable long id) {
		return (CreditType) dao.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<CreditType> getAll() {
		return (List<CreditType>) dao.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<CreditType> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<CreditType>) dao.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody CreditType creditType) throws ValidationException{
		service.update(creditType, validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		dao.findById(id);
	}
	
}

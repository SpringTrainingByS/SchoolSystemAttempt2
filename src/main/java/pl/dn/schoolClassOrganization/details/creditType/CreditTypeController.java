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
import pl.dn.base.history.BaseDetailHistoryService;
import pl.dn.exception.ValidationException;
import pl.dn.schoolClassOrganization.details.creditType.history.CreditTypeRegistry;
import pl.dn.schoolClassOrganization.details.prefix.history.ClassPrefixRegistry;

@RestController
@RequestMapping(value = "credit-type")
public class CreditTypeController {

	private BaseDetailService service;
	
	private String[] validationPatterns = {
			"^[\\p{L}]+$", 
			"^[\\p{L}]+[\\s]{1}[\\p{L}]+$"};

	@Autowired
	public CreditTypeController(BaseDetailService service, CreditTypeDao creditTypeDao,
								 BaseDetailHistoryService<CreditType, CreditTypeRegistry> bdhService) {

		this.service = service;
		this.service.setBaseDetailDao(creditTypeDao);
		bdhService.setBaseDetailDao(creditTypeDao);
		this.service.setBdhService(bdhService);

	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public void add(@RequestBody CreditType creditType) throws ValidationException {
		service.add(creditType,  new CreditTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "add-set", method = RequestMethod.POST)
	public void addSet(@RequestBody List<CreditType> creditType) throws ValidationException {
		service.addSet(creditType, new CreditTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "get/{id}", method = RequestMethod.GET)
	public CreditType get(@PathVariable long id) {
		return (CreditType) service.findById(id);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get/all", method = RequestMethod.GET)
	public List<CreditType> getAll() {
		return (List<CreditType>) service.findAll();
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value = "get", params = {"limit", "offset"}, method = RequestMethod.GET)
	public List<CreditType> getByPagination(@RequestParam("limit") int limit, @RequestParam("offset") int offset) {
		return (List<CreditType>) service.findByPagination(limit, offset);
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public void update(@RequestBody CreditType creditType) throws ValidationException{
		service.update(creditType, new CreditTypeRegistry(), validationPatterns);
	}
	
	@RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable long id) {
		service.findById(id);
	}

    @RequestMapping(value = "find", method = RequestMethod.POST)
    public List<CreditType> find(@RequestBody List<String> keyWords) {
        return  (List<CreditType>) service.find(keyWords);
    }
	
}

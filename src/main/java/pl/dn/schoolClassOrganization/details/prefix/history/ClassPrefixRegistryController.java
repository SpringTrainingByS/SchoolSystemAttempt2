package pl.dn.schoolClassOrganization.details.prefix.history;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pl.dn.schoolClassOrganization.details.prefix.history.customModels.CustomPrefixRegistryResponse;

@RestController
@RequestMapping(value = "class-prefix-registry")
public class ClassPrefixRegistryController {
	
	private ClassPrefixRegistryDao dao;
	
	@Autowired
	public ClassPrefixRegistryController(ClassPrefixRegistryDao dao) {
		this.dao = dao;
	}

	@RequestMapping(value = "get/{prefixId}", method = RequestMethod.GET)
	public List<CustomPrefixRegistryResponse> get(@PathVariable long prefixId) {
		return dao.findByPrefixId(prefixId);
	}
	
}

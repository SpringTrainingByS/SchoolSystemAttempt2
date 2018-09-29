package pl.dn.schoolClassOrganization.details.creditType.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dn.base.customModels.BaseDetailRegistryResponse;
import pl.dn.schoolClassOrganization.details.classType.history.ClassTypeRegistryDao;

import java.util.List;

@RestController
@RequestMapping(value = "credit-type-registry")
public class CreditTypeRegistryController {

    private ClassTypeRegistryDao dao;

    @Autowired
    public CreditTypeRegistryController(ClassTypeRegistryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "get/{creditTypeId}", method = RequestMethod.GET)
    public List<BaseDetailRegistryResponse> get(@PathVariable long creditTypeId) {
        return dao.findByClassTypeId(creditTypeId);
    }
}

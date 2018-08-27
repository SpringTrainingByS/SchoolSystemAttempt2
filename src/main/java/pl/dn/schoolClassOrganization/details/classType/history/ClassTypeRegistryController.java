package pl.dn.schoolClassOrganization.details.classType.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dn.base.customModels.BaseDetailRegistryResponse;

import java.util.List;

@RestController
@RequestMapping(value = "class-type-registry")
public class ClassTypeRegistryController {

    private ClassTypeRegistryDao dao;

    @Autowired
    public ClassTypeRegistryController(ClassTypeRegistryDao classTypeRegistryDao) {
        this.dao = classTypeRegistryDao;
    }

    @RequestMapping(value = "get/{classTypeId}", method = RequestMethod.GET)
    public List<BaseDetailRegistryResponse> get(@PathVariable long classTypeId) {
        return dao.findByClassTypeId(classTypeId);
    }
}

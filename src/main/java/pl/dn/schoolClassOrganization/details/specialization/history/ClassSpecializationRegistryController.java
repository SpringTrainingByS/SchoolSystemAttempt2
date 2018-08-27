package pl.dn.schoolClassOrganization.details.specialization.history;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pl.dn.base.customModels.BaseDetailRegistryResponse;

import java.util.List;

@RestController
@RequestMapping(value = "class-prefix-registry")
public class ClassSpecializationRegistryController {

    private ClassSpecializationRegistryDao dao;

    @Autowired
    public ClassSpecializationRegistryController(ClassSpecializationRegistryDao dao) {
        this.dao = dao;
    }

    @RequestMapping(value = "get/{specializationId}", method = RequestMethod.GET)
    public List<BaseDetailRegistryResponse> get(@PathVariable long specializationId) {
        return dao.findBySpecializationId(specializationId);
    }

}

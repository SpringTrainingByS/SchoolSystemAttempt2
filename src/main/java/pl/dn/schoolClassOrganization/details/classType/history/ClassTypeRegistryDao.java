package pl.dn.schoolClassOrganization.details.classType.history;

import pl.dn.base.customModels.BaseDetailRegistryResponse;
import pl.dn.history.RegistryDao;

import java.util.List;

public interface ClassTypeRegistryDao extends RegistryDao<ClassTypeRegistry> {

    public List<BaseDetailRegistryResponse> findByClassTypeId(long id);

}

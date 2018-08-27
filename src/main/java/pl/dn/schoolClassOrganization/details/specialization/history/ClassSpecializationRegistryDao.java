package pl.dn.schoolClassOrganization.details.specialization.history;

import org.springframework.stereotype.Repository;
import pl.dn.base.customModels.BaseDetailRegistryResponse;
import pl.dn.history.RegistryDao;

import java.util.List;

@Repository
public interface ClassSpecializationRegistryDao extends RegistryDao<ClassSpecializationRegistry> {

    public List<BaseDetailRegistryResponse> findBySpecializationId(long id);

}

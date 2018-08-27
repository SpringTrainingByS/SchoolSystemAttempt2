package pl.dn.schoolClassOrganization.details.creditType.history;

import org.springframework.stereotype.Repository;
import pl.dn.base.customModels.BaseDetailRegistryResponse;
import pl.dn.history.RegistryDao;

import java.util.List;

@Repository
public interface CreditTypeRegistryDao extends RegistryDao<CreditTypeRegistry> {

    public List<BaseDetailRegistryResponse> findByCreditTypeId(long id);

}

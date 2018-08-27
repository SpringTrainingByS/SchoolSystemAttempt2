package pl.dn.schoolClassOrganization.details.prefix.history;

import java.util.List;

import org.springframework.stereotype.Repository;

import pl.dn.history.RegistryDao;
import pl.dn.base.customModels.BaseDetailRegistryResponse;

@Repository
public interface ClassPrefixRegistryDao extends RegistryDao<ClassPrefixRegistry> {

	public List<BaseDetailRegistryResponse> findByPrefixId(long id);
	
}

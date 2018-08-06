package pl.dn.schoolClassOrganization.details.prefix.history;

import org.springframework.stereotype.Repository;

import pl.dn.history.RegistryDao;

@Repository
public interface ClassPrefixRegistryDao extends RegistryDao<ClassPrefixRegistry> {

	public ClassPrefixRegistry findByPrefixId(long id);
	
}

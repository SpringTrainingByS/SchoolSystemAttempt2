package pl.dn.dao.schoolClassOrganization.details;

import org.springframework.data.repository.CrudRepository;

import pl.dn.model.schoolClassOrganization.details.ClassPrefix;

public interface ClassPrefixDao extends CrudRepository<ClassPrefix, Long>{
	
	public ClassPrefix findByName(String name);
	public ClassPrefix findById(Long id);
	public void deleteById(Long id);
}

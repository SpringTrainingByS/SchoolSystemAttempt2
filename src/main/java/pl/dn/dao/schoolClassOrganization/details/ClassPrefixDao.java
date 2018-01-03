package pl.dn.dao.schoolClassOrganization.details;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import pl.dn.model.schoolClassOrganization.details.ClassPrefix;

public interface ClassPrefixDao extends CrudRepository<ClassPrefix, Long>{
	
	public ClassPrefix findByName(String name);
	
}

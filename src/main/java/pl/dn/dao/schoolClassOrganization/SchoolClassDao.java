package pl.dn.dao.schoolClassOrganization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import pl.dn.model.schoolClassOrganization.SchoolClass;

public interface SchoolClassDao extends CrudRepository<SchoolClass, Long> {
	public SchoolClass findById(long id);
	
	//@Query(value = "SELECT * FROM school_class WHERE prefix_id = :id", nativeQuery = true) 
	public List<SchoolClass> findByPrefixId(long id);
}

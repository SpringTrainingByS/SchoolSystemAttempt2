package pl.dn.dao.schoolClassOrganization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.dn.model.schoolClassOrganization.SchoolClass;

public interface SchoolClassDao extends CrudRepository<SchoolClass, Long> {
	
	public SchoolClass findById(long id);
	public List<SchoolClass> findByPrefixId(long id);
	public List<SchoolClass> findAll();
	
	@Query(value = "SELECT * FROM school_class LIMIT :limit OFFSET :offset", nativeQuery = true) 
	public List<SchoolClass> findByPagination(@Param("limit") int limit, @Param("offset") int offset);
}

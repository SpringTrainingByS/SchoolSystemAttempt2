package pl.dn.schoolClassOrganization.schoolClass;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SchoolClassDao extends CrudRepository<SchoolClass, Long> {
	
	public SchoolClass findById(long id);
	public List<SchoolClass> findByPrefixId(long id);
	public List<SchoolClass> findAll();
	public void deleteById(long id);
	
	@Query(value = "SELECT * FROM school_class LIMIT :limit OFFSET :offset", nativeQuery = true) 
	public List<SchoolClass> findByPagination(@Param("limit") int limit, @Param("offset") int offset);
}

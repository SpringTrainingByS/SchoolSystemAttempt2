package pl.dn.schoolClassOrganization.schoolClass;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface SchoolClassDao extends CrudRepository<SchoolClass, Long> {
	
	SchoolClass findById(long id);
	List<SchoolClass> findByPrefixId(long id);
	List<SchoolClass> findAll();
	void deleteById(long id);
	SchoolClass save(SchoolClass schoolClass);

	@Query(value = "SELECT * FROM school_class LIMIT :limit OFFSET :offset", nativeQuery = true)
	List<SchoolClass> findByPagination(@Param("limit") int limit, @Param("offset") int offset);

	List<SchoolClass> findByPrefixNameAndTypeName(String prefix, String type);
}

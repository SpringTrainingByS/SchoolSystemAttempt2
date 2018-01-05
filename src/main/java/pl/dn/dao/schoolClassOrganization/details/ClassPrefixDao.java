package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dn.model.schoolClassOrganization.details.ClassDetail;

@Repository
public interface ClassPrefixDao extends ClassDetailDao {
	
	
	@Query(value = "SELECT * FROM class_prefix LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<ClassDetail> findByPagination
		(@Param("limitValue") int limit, @Param("offsetValue") int offset);
}

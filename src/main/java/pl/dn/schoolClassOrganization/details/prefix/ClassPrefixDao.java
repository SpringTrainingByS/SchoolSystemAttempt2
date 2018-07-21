package pl.dn.schoolClassOrganization.details.prefix;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dn.base.BaseDetailDao;

@Repository
public interface ClassPrefixDao extends BaseDetailDao<ClassPrefix> {
	
	@Query(value = "SELECT * FROM class_prefix LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<ClassPrefix> findByPagination
	(@Param("limitValue") int limit, @Param("offsetValue") int offset);
}

package pl.dn.schoolClassOrganization.details.classType;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;
import pl.dn.base.BaseDetailDao;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;

@Repository
public interface ClassTypeDao extends BaseDetailDao<ClassType> {

	@Query(value = "SELECT * FROM class_type LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<ClassType> findUsePagination
			(@Param("limitValue") int limit, @Param("offsetValue") int offset);
	
}

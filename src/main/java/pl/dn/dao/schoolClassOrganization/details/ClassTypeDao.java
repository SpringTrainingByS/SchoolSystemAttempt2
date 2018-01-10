package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dn.dao.base.BaseDetailDao;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.model.schoolClassOrganization.details.ClassType;

public interface ClassTypeDao extends BaseDetailDao<ClassType> {

	@Query(value = "SELECT * FROM class_type LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<ClassType> findByPagination
	(@Param("limitValue") int limit, @Param("offsetValue") int offset);
	
}

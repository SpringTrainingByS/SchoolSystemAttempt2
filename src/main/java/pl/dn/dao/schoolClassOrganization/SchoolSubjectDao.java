package pl.dn.dao.schoolClassOrganization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dn.dao.base.BaseDetailDao;
import pl.dn.model.schoolClassOrganization.SchoolClass;
import pl.dn.model.schoolClassOrganization.SchoolSubject;

public interface SchoolSubjectDao extends BaseDetailDao<SchoolSubject> {
	
	@Query(value = "SELECT * FROM school_subject LIMIT :limit OFFSET :offset", nativeQuery = true) 
	public List<SchoolSubject> findByPagination(@Param("limit") int limit, @Param("offset") int offset);

}

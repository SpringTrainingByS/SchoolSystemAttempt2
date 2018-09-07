package pl.dn.schoolClassOrganization.schoolSubject;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dn.base.BaseDetailDao;
import pl.dn.schoolClassOrganization.schoolClass.SchoolClass;

public interface SchoolSubjectDao extends BaseDetailDao<SchoolSubject> {
	
	@Query(value = "SELECT * FROM school_subject LIMIT :limit OFFSET :offset", nativeQuery = true) 
	public List<SchoolSubject> findUsePagination(@Param("limit") int limit, @Param("offset") int offset);

}

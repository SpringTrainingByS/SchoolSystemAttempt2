package pl.dn.schoolClassOrganization.details.specialization;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dn.base.BaseDetailDao;

@Repository
public interface ClassSpecializationDao extends BaseDetailDao<ClassSpecialization>{
	
	@Query(value = "SELECT * FROM class_specialization LIMIT :limit OFFSET :offset", nativeQuery = true)
	public List<ClassSpecialization> findByPagination
		(@Param("limit") int limit, @Param("offset") int offset);
	
}

package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dn.model.schoolClassOrganization.details.ClassSpecialization;

@Repository
public interface ClassSpecializationDao extends ClassDetailDao<ClassSpecialization>{
	
	@Query(value = "SELECT * FROM class_specialization LIMIT :limit OFFSET :offset", nativeQuery = true)
	public List<ClassSpecialization> findByPagination
		(@Param("limit") int limit, @Param("offset") int offset);
	
}

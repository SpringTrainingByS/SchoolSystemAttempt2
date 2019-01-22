package pl.dn.schoolClassOrganization.occupationalGroup;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import pl.dn.user.User;

import javax.transaction.Transactional;

@Transactional
public interface OccupationalGroupDao extends CrudRepository<OccupationalGroup, Long>{
	
	OccupationalGroup findById(long id);
	List<OccupationalGroup> findAll();
	List<OccupationalGroup> findBySchoolClassId(long id);
	List<OccupationalGroup> findByTeacherId(long id);
	List<OccupationalGroup> findBySchoolClassIdAndTeacherId(long schoolClassId, long teacherId);
	List<OccupationalGroup> findBySchoolSubjectId(long id);
	
	void deleteById(long id);

	@Query(value = "SELECT * FROM occupational_group LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	List<OccupationalGroup> findByPagination(@Param("limitValue") int limit, @Param("offsetValue") int offset);
}

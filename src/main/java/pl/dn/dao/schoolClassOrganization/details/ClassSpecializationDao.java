package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pl.dn.model.schoolClassOrganization.details.ClassSpecialization;

@Repository
public interface ClassSpecializationDao extends CrudRepository<ClassSpecialization, Long>{
	
	public ClassSpecialization findById(Long id);
	public ClassSpecialization findByName(String name);
	public void deleteById(long id);
	public List<ClassSpecialization> findAll();
	
	@Query(value = "SELECT * FROM class_specialization LIMIT :limit OFFSET :offset", nativeQuery = true)
	public List<ClassSpecialization> findByPagination(@Param("limit") int limit, @Param("offset") int offset);
	
}

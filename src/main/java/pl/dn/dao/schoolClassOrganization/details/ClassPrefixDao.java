package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.dn.model.schoolClassOrganization.details.ClassPrefix;

public interface ClassPrefixDao extends CrudRepository<ClassPrefix, Long>{
	
	public ClassPrefix findByName(String name);
	public ClassPrefix findById(Long id);
	public void deleteById(Long id);
	public List<ClassPrefix> findAll();
	
	@Query(value = "SELECT * FROM class_prefix LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<ClassPrefix> findByPagination
		(@Param("limitValue") int limit, @Param("offsetValue") int offset);
}

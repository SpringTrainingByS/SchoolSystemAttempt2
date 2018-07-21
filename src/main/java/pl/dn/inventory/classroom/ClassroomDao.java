package pl.dn.inventory.classroom;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomDao extends CrudRepository<Classroom, Long> {
	public void delete(Classroom classroom);
	public Classroom findById(Long id);
	public List<Classroom> findAll();
	public Classroom findByNumber(String number);
	
	@Query(value = "SELECT * FROM classroom LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<Classroom> findByPagination
		(@Param("limitValue") int limit, @Param("offsetValue") int offset);
}

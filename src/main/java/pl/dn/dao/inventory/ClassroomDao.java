package pl.dn.dao.inventory;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.model.inventory.Classroom;

@Repository
public interface ClassroomDao extends CrudRepository<Classroom, Long> {
	public void delete(Classroom classroom);
	public void findById(Long id);
}

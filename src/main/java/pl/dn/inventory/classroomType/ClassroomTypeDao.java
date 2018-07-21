package pl.dn.inventory.classroomType;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomTypeDao extends CrudRepository<ClassroomType, Long>{
	public ClassroomType findById(long id);
	public ClassroomType findByName(String name);
	public List<ClassroomType> findAll();
	public void delete(long id);
}

package pl.dn.dao.inventory;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.model.inventory.ClassroomType;

@Repository
public interface ClassroomTypeDao extends CrudRepository<ClassroomType, Long>{
	public ClassroomType findById(long id);
	public List<ClassroomType> findAll();
	public void delete(long id);
}

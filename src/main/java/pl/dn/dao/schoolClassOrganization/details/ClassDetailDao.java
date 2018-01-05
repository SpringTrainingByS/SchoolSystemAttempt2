package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import javax.persistence.MappedSuperclass;

import org.springframework.data.repository.CrudRepository;

import pl.dn.model.schoolClassOrganization.details.ClassDetail;


public interface ClassDetailDao extends CrudRepository<ClassDetail, Long> {
	
	public ClassDetail findByName(String name);
	public ClassDetail findById(Long id);
	public void deleteById(Long id);
	public List<ClassDetail> findAll();
	public List<ClassDetail> findByPagination(int limit, int offset);
	
}

package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import pl.dn.model.schoolClassOrganization.details.BaseDetail;

@NoRepositoryBean
public interface ClassDetailDao<T extends BaseDetail> extends CrudRepository<T, Long> {
	
	public T findByName(String name);
	public T findById(Long id);
	public void deleteById(Long id);
	public List<T> findAll();
	public List<T> findByPagination(int limit, int offset);
	
}

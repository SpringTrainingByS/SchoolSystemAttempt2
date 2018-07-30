package pl.dn.base;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
@Transactional
public interface BaseDetailDao<T extends BaseDetail> extends CrudRepository<T, Long> {
	
	public T findByName(String name);
	public T findById(Long id);
	public void deleteById(Long id);
	public List<T> findAll();
	public List<T> findByPagination(int limit, int offset);
	public String findNameById(long id);
	
}

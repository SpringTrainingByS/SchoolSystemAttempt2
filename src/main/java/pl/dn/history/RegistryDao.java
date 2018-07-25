package pl.dn.history;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

@NoRepositoryBean
@Transactional
public interface RegistryDao<T extends Registry> extends JpaRepository<T, Long> {
	
	public T findByUserId(long userId);
	public T save(T registry);
	
}

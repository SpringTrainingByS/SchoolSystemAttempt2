package pl.dn.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public User save(User user);
	public void delete(User user);
	public User findById(Long id);
}

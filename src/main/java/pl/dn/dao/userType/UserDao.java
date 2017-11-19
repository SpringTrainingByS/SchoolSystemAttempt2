package pl.dn.dao.userType;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.model.userType.User;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public User save(User user);
	public void delete(User user);
	public User findById(Long id);
}

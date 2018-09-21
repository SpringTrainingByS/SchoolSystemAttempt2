package pl.dn.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	public User save(User user);
	public void delete(User user);
	public User findById(Long id);
	public List<User> findAll();

	@Query(value = "SELECT * FROM user LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<User> findByPagination(@Param("limitValue") int limit,@Param("offsetValue") int offset);
}

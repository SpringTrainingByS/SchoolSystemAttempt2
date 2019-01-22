package pl.dn.user;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.user.model.UserParams;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User, Long> {
	User save(User user);
	void delete(User user);
	User findById(Long id);
	long count();

	@Query(value = "SELECT * FROM user", nativeQuery = true)
	List<User> findAllUsers();

	@Query(value = "SELECT * FROM user LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	List<User> findByPagination(@Param("limitValue") int limit,@Param("offsetValue") int offset);

	@Query(value = "SELECT * FROM user WHERE first_name = :firstName" +
			" AND last_name = :lastName " +
			"OR pesel = :pesel ", nativeQuery =  true)
	List<User> findByBasicInfo(@Param("firstName") String firstName,
									  @Param("lastName") String secondName,
									  @Param("pesel") String pesel);

	@Query(value = "SELECT * FROM user" +
			" LEFT JOIN login_info ON user.login_info_id = login_info.id " +
			" LEFT JOIN role ON login_info.role_id = role.id " +
			" WHERE (user.first_name = :firstName" +
			" AND user.last_name = :lastName AND role.name = :roleName) " +
			"OR (pesel = :pesel  AND role.name = :roleName)", nativeQuery =  true)
	public List<User> findByBasicInfoAndRole(@Param("firstName") String firstName,
											 @Param("lastName") String secondName,
											 @Param("pesel") String pesel, @Param("roleName") String roleName);
}

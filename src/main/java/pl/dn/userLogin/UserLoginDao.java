package pl.dn.userLogin;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.dn.security.common.UserLoginInfo;

public interface UserLoginDao extends CrudRepository<UserLogin, Long> {

	public UserLogin findById(long id);
	public UserLoginInfo findByUsername(String username);
	
	@Query(value = "SELECT id FROM user_login WHERE usernmae = :username", nativeQuery = true)
	public Long findIdByUsername(@Param("username") String username);
	
}

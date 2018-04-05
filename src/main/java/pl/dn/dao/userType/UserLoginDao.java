package pl.dn.dao.userType;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import pl.dn.model.userType.UserLogin;
import pl.dn.service.jwt.common.LoginRequest;
import pl.dn.service.jwt.common.UserLoginInfo;

public interface UserLoginDao extends CrudRepository<UserLogin, Long> {

	public UserLogin findById(long id);
	public UserLoginInfo findByUsername(String username);
	
	@Query(value = "SELECT id FROM user_login WHERE usernmae = :username", nativeQuery = true)
	public Long findIdByUsername(@Param("username") String username);
	
}

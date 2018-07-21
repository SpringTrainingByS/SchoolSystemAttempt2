package pl.dn.security.userRole;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.security.Role;
import pl.dn.security.UserRoleOnly;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Long> {
	
	public List<UserRole> findByUserLoginId(long id);
	

}

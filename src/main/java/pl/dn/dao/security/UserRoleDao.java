package pl.dn.dao.security;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.model.security.Role;
import pl.dn.model.security.UserRole;
import pl.dn.model.security.UserRoleOnly;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Long> {
	
	public List<UserRole> findByUserLoginId(long id);
	

}

package pl.dn.dao.security;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pl.dn.model.security.UserRole;
import pl.dn.model.security.UserRoleOnly;

@Repository
public interface UserRoleDao extends CrudRepository<UserRole, Long> {
	
	public List<UserRoleOnly> findByUserLoginId(long id);
	

}

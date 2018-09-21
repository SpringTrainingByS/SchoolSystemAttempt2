package pl.dn.security.role;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {
    public Role findById(long id);
    public List<Role> findAll();
}

package pl.dn.dao.userType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dn.model.userType.Moderator;

/**
 * Created by User on 25.08.2017.
 */
@Repository
public interface ModeratorDao extends CrudRepository<Moderator, Long> {

    public void delete(long id);
    public Moderator save(Moderator moderator);
    public Moderator findById(Long id);

}

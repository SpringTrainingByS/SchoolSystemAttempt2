package pl.dn.dao.userType;

import org.springframework.data.repository.CrudRepository;
import pl.dn.model.userType.Moderator;

/**
 * Created by User on 25.08.2017.
 */
public interface ModeratorDao extends CrudRepository<Moderator, Long>{

    public Moderator findById(long id);
    public Moderator save(Moderator moderator);

}

package pl.dn.dao.placeInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dn.model.placeInfo.Street;

/**
 * Created by User on 01.09.2017.
 */
@Repository
public interface StreetDao extends CrudRepository<Street, Long> {

    public Street findByName(String name);
    public Street findById(long id);

}

package pl.dn.dao.placeInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dn.model.placeInfo.Voivodeship;

/**
 * Created by User on 01.09.2017.
 */
@Repository
public interface VoivodeshipDao extends CrudRepository<Voivodeship, Long> {

    public Voivodeship findByName(String name);
    public Voivodeship findById(long id);

}

package pl.dn.dao.placeInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dn.model.placeInfo.City;

/**
 * Created by User on 30.08.2017.
 */
@Repository
public interface CityDao extends CrudRepository<City, Long> {

    public City findById(Long id);
    public City findByName(String name);

}

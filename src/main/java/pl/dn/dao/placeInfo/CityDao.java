package pl.dn.dao.placeInfo;

import org.springframework.data.repository.CrudRepository;
import pl.dn.model.placeInfo.City;

/**
 * Created by User on 30.08.2017.
 */
public interface CityDao extends CrudRepository<City, Long> {

    public City findById(Long id);

}

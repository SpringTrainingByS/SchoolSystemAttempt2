package pl.dn.dao.placeInfo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.dn.model.placeInfo.ZipCode;

/**
 * Created by User on 01.09.2017.
 */
@Repository
public interface ZipCodeDao extends CrudRepository<ZipCode, Long> {

    public ZipCode findById(long id);
    public ZipCode findByValue(String value);

}


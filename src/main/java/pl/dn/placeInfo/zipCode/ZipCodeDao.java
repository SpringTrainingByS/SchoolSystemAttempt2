package pl.dn.placeInfo.zipCode;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.base.BaseDetailDao;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.voivodeship.Voivodeship;

import java.util.List;

@Repository
public interface ZipCodeDao extends BaseDetailDao<ZipCode>{

    @Query(value = "SELECT * FROM zip_code LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
    public List<ZipCode> findUsePagination
            (@Param("limitValue") int limit, @Param("offsetValue") int offset);

}

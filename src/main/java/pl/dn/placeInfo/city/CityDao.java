package pl.dn.placeInfo.city;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.base.BaseDetailDao;
import pl.dn.schoolClassOrganization.details.classType.ClassType;

import java.util.List;

@Repository
public interface CityDao extends BaseDetailDao<City> {

    @Query(value = "SELECT * FROM city LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
    public List<City> findUsePagination
            (@Param("limitValue") int limit, @Param("offsetValue") int offset);

}

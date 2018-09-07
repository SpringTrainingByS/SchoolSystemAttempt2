package pl.dn.placeInfo.street;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.base.BaseDetailDao;

import java.util.List;

@Repository
public interface StreetDao extends BaseDetailDao<Street> {

    @Query(value = "SELECT * FROM street LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
    public List<Street> findUsePagination
            (@Param("limitValue") int limit, @Param("offsetValue") int offset);

}

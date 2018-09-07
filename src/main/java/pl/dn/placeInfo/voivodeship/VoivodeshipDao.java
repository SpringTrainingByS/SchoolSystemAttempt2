package pl.dn.placeInfo.voivodeship;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dn.base.BaseDetailDao;
import pl.dn.schoolClassOrganization.details.classType.ClassType;

import java.util.List;

@Repository
public interface VoivodeshipDao extends BaseDetailDao<Voivodeship> {

    @Query(value = "SELECT * FROM voivodeship LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
    public List<Voivodeship> findUsePagination
            (@Param("limitValue") int limit, @Param("offsetValue") int offset);

}

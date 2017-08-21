package pl.dn.dao.bornInfo;

import org.springframework.data.repository.CrudRepository;
import pl.dn.model.bornInfo.AdminBornInfo;

/**
 * Created by User on 17.08.2017.
 */
public interface AdminBornInfoDao extends CrudRepository<AdminBornInfo, Long> {

}

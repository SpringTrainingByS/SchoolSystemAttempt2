package pl.dn.dao.schoolClassOrganization.details;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dn.dao.base.BaseDetailDao;
import pl.dn.model.schoolClassOrganization.details.CreditType;

public interface CreditTypeDao extends BaseDetailDao<CreditType> {

	@Query(value = "SELECT * FROM credit_type LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<CreditType> findByPagination
	(@Param("limitValue") int limit, @Param("offsetValue") int offset);
	
}

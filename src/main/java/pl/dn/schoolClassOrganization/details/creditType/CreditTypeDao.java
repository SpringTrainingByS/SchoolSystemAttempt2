package pl.dn.schoolClassOrganization.details.creditType;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pl.dn.base.BaseDetailDao;

public interface CreditTypeDao extends BaseDetailDao<CreditType> {

	@Query(value = "SELECT * FROM credit_type LIMIT :limitValue OFFSET :offsetValue", nativeQuery = true)
	public List<CreditType> findByPagination
	(@Param("limitValue") int limit, @Param("offsetValue") int offset);
	
}

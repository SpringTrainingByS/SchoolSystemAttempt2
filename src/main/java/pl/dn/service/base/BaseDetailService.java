package pl.dn.service.base;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.base.BaseDetailDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.base.BaseDetail;
import pl.dn.validation.base.BaseDetailValidator;

@Service
@Transactional
public class BaseDetailService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private BaseDetailValidator classDetailValidator;
	
	public void add(BaseDetail classDetail, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException{
		classDetailValidator.validateBeforeAdd(classDetail, dao, validationPatterns);
		Session session = sessionFactory.getCurrentSession();
		session.save(classDetail);
	}
	
	public void addSet(List<? extends BaseDetail> classDetailGroup, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		
		for (BaseDetail classDetail : classDetailGroup ) {
			try {
				classDetailValidator.validateBeforeAdd(classDetail, dao, validationPatterns);
				session.save(classDetail);
			}
			catch (ValidationException e) {
				message += "Problem dla encji: " + classDetail.getName() + ": ";
				message += e.getMessage();
				message += ";";
			}
		}
		
		if (!message.isEmpty()) {
			throw new ValidationException(message);
		}
	}
	
	public BaseDetail getById(Long id, BaseDetailDao<?> dao)  {
		return dao.findById(id);
	}
	
	public List<?> getByPagination(int limit, int offset, BaseDetailDao<?> dao) {
		List<?> classDetails = dao.findByPagination(limit, offset);
		
		return classDetails;
	}
	
	public List<?> getAll(BaseDetailDao<?> dao) {
		return dao.findAll();
	}
 	
	public void update(BaseDetail classDetail, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException {
		classDetailValidator.validateBeforeUpdate(classDetail, dao, validationPatterns);
		Session session = sessionFactory.getCurrentSession();
		session.update(classDetail);
	}
	
	public void deleteById(long id, BaseDetailDao<?> dao)  {
		dao.deleteById(id);
	}
}

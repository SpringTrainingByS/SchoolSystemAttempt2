package pl.dn.base;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;

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
		classDetail.setCreationTime(new Date());
		session.save(classDetail);
	}
	
	public void addSet(List<? extends BaseDetail> classDetailGroup, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		
		for (BaseDetail classDetail : classDetailGroup ) {
			try {
				classDetailValidator.validateBeforeAdd(classDetail, dao, validationPatterns);
				classDetail.setCreationTime(new Date());
				session.save(classDetail);
			}
			catch (ValidationException e) {
				message += "Problem dla encji: " + classDetail.getName() + ": ";
				message += e.getMessage();
			}
		}
		
		if (!message.isEmpty()) {
			throw new ValidationException(message);
		}
	}
	
	public void update(BaseDetail classDetail, BaseDetailDao<?> dao, String[] validationPatterns) throws ValidationException {
		classDetailValidator.validateBeforeUpdate(classDetail, dao, validationPatterns);
		Session session = sessionFactory.getCurrentSession();
		session.update(classDetail);
	}
	
}

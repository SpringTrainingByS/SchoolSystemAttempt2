package pl.dn.service.schoolClassOrganization.details;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.details.ClassDetailDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassDetail;
import pl.dn.validation.inventory.schoolClassOrganization.details.ClassDetailValidator;

@Service
@Transactional
public class ClassDetailService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ClassDetailValidator classDetailValidator;
	
	public void add(ClassDetail classDetail, ClassDetailDao dao) throws ValidationException{
		classDetailValidator.validateBeforeAdd(classDetail, dao);
		Session session = sessionFactory.getCurrentSession();
		session.save(classDetail);
	}
	
	public void addSet(List<? extends ClassDetail> classDetailGroup, ClassDetailDao dao) throws ValidationException {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		
		for (ClassDetail classDetail : classDetailGroup ) {
			try {
				classDetailValidator.validateBeforeAdd(classDetail, dao);
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
	
	public ClassDetail getById(Long id, ClassDetailDao dao)  {
		return dao.findById(id);
	}
	
	public List<ClassDetail> getByPagination(int limit, int offset, ClassDetailDao dao) {
		List<ClassDetail> classDetails = dao.findByPagination(limit, offset);
		
		return classDetails;
	}
	
	public List<ClassDetail> getAll(ClassDetailDao dao) {
		return dao.findAll();
	}
 	
	public void update(ClassDetail classDetail, ClassDetailDao dao) throws ValidationException {
		classDetailValidator.validateBeforeUpdate(classDetail, dao);
		Session session = sessionFactory.getCurrentSession();
		session.update(classDetail);
	}
	
	public void deleteById(long id, ClassDetailDao dao)  {
		dao.deleteById(id);
	}
}

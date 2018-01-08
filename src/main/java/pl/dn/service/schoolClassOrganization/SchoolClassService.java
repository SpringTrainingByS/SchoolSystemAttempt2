package pl.dn.service.schoolClassOrganization;

import java.util.Date;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.SchoolClassDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.SchoolClass;
import pl.dn.validation.inventory.schoolClassOrganization.details.SchoolClassValidator;

@Service
@Transactional
public class SchoolClassService {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private SchoolClassDao schoolClassDao;
	
	@Autowired
	private SchoolClassValidator validator;
	
	public void add(SchoolClass schoolClass) throws ValidationException {
		validator.validateBeforeAdd(schoolClass);
		Session session = sessionFactory.getCurrentSession();
		schoolClass.setStartDate(new Date());
		session.save(schoolClass);
	}
	
	public SchoolClass getById(long id) {
		return schoolClassDao.findById(id);
	}
	
}

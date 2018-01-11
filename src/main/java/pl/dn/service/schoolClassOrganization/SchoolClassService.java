package pl.dn.service.schoolClassOrganization;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.SchoolClassDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.SchoolClass;
import pl.dn.validation.schoolClassOrganization.SchoolClassValidator;

@Service
@Transactional
public class SchoolClassService {

	@Autowired
	private SessionFactory sessionFactory;

	
	@Autowired
	private SchoolClassValidator validator;
	
	public void add(SchoolClass schoolClass) throws ValidationException {
		validator.validateBeforeAdd(schoolClass);
		Session session = sessionFactory.getCurrentSession();
		Calendar calendar = Calendar.getInstance();
		schoolClass.setStartDate(calendar);
		session.save(schoolClass);
	}
	
	
	public void update(SchoolClass schoolClass) throws ValidationException {
		validator.validateBeforeUpdate(schoolClass);
		Session session = sessionFactory.getCurrentSession();
		session.update(schoolClass);
	}
	
}

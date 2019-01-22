package pl.dn.schoolClassOrganization.schoolClass;

import java.util.Calendar;
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
public class SchoolClassService {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private SchoolClassDao dao;

	
	@Autowired
	private SchoolClassValidator validator;
	
	public void add(SchoolClass schoolClass) throws ValidationException {
		System.out.println("");
		validator.validateBeforeAdd(schoolClass);
//		Session session = sessionFactory.getCurrentSession();
		System.out.println("Próba zapisu do bazy");
		dao.save(schoolClass);
	}
	
	
	public void update(SchoolClass schoolClass) throws ValidationException {
		validator.validateBeforeUpdate(schoolClass);
		Session session = sessionFactory.getCurrentSession();
		session.update(schoolClass);
	}

	public List<SchoolClass> findByPrefixAndType(String prefix, String type) {
		return dao.findByPrefixNameAndTypeName(prefix, type);
	}
	
}

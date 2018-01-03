package pl.dn.service.schoolClassOrganization.details;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;
import pl.dn.model.schoolClassOrganization.details.ClassPrefix;
import pl.dn.validation.inventory.schoolClassOrganization.details.ClassPrefixValidator;

@Service
@Transactional
public class ClassPrefixService {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ClassPrefixValidator classPrefixValidator;
	
	public void add(ClassPrefix classPrefix) throws ValidationException{
		classPrefixValidator.validateBeforeAdd(classPrefix);
		Session session = sessionFactory.getCurrentSession();
		session.save(classPrefix);
	}
}

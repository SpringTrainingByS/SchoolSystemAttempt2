package pl.dn.service.schoolClassOrganization.details;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.schoolClassOrganization.details.ClassPrefixDao;
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
	
	@Autowired
	private ClassPrefixDao classPrefixDao;
	
	public void add(ClassPrefix classPrefix) throws ValidationException{
		classPrefixValidator.validateBeforeAdd(classPrefix);
		Session session = sessionFactory.getCurrentSession();
		session.save(classPrefix);
	}
	
	public void addSet(List<ClassPrefix> classPrefixGroup) throws ValidationException {
		String message = "";
		Session session = sessionFactory.getCurrentSession();
		
		for (ClassPrefix classPrefix : classPrefixGroup ) {
			try {
				classPrefixValidator.validateBeforeAdd(classPrefix);
				session.save(classPrefix);
			}
			catch (ValidationException e) {
				message += "Problem dla prefiksu " + classPrefix.getName() + ": ";
				message += e.getMessage();
				message += ";";
			}
		}
		
		if (!message.isEmpty()) {
			throw new ValidationException(message);
		}
	}
	
	public ClassPrefix getById(Long id)  {
		return classPrefixDao.findById(id);
	}
	
	public List<ClassPrefix> getByPagination(int limit, int offset) {
		List<ClassPrefix> classPrefixes = classPrefixDao.findByPagination(limit, offset);
		
		return classPrefixes;
	}
	
	public List<ClassPrefix> getAll() {
		return classPrefixDao.findAll();
	}
 	
	public void update(ClassPrefix classPrefix) throws ValidationException {
		classPrefixValidator.validateBeforeUpdate(classPrefix);
		Session session = sessionFactory.getCurrentSession();
		session.update(classPrefix);
	}
	
	public void deleteById(long id)  {
		classPrefixDao.deleteById(id);
	}
}

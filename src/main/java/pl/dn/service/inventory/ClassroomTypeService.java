package pl.dn.service.inventory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.inventory.ClassroomTypeDao;
import pl.dn.exception.ValidationException;
import pl.dn.model.inventory.ClassroomType;
import pl.dn.validation.inventory.ClassroomTypeValidator;

@Service
@Transactional
public class ClassroomTypeService {
	
	@Autowired 
	private ClassroomTypeDao classroomTypeDao;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Autowired
	private ClassroomTypeValidator validatior;
	
	
	public void add(ClassroomType classroomType) throws ValidationException {
		validatior.validateBeforeAdd(classroomType);
		Session session = sessionFactory.getCurrentSession();
		session.save(classroomType);
	}
	
	public ClassroomType get(long id) {
		return classroomTypeDao.findById(id);
	}
	
	public List<ClassroomType> getAll() {
		return classroomTypeDao.findAll();
	}
	
	public void udpate(ClassroomType classroomType) throws ValidationException {
		validatior.validateBeforeUpdate(classroomType);
		Session session = sessionFactory.getCurrentSession();
		session.update(classroomType);
	}
	
	public void delete(long id) {
		classroomTypeDao.delete(id);
	}
}

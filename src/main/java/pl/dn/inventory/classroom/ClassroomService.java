package pl.dn.inventory.classroom;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.exception.ValidationException;


@Service
@Transactional
public class ClassroomService {
	
	@Autowired
	private ClassroomDao classroomDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	private ClassroomValidator classroomValidator;
	
	public void add(Classroom classroom) throws ValidationException {
		classroomValidator.validateBeforeAdd(classroom);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(classroom);
	}
	
	public Classroom getById(long id) {
		return classroomDao.findById(id);
	}
	
	public Classroom getByNumber(String number) {
		return classroomDao.findByNumber(number);
	}
	
	public List<Classroom> getByPagination(int limit, int offset) {
		return classroomDao.findByPagination(limit, offset);
	}
	
	public List<Classroom> getAll() {
		return classroomDao.findAll();
	}
	
	public void update(Classroom classroom) throws ValidationException {
		classroomValidator.validateBeforeUpdate(classroom);
		Session session = sessionFactory.getCurrentSession();
		session.update(classroom);
	}
	
	public void deleteById(long id) {
		Classroom classroom = classroomDao.findById(id);
		classroom.setType(null);
		classroomDao.delete(classroom);
	}
	
	
	
	
	
}

package pl.dn.service.inventory;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.inventory.ClassroomDao;
import pl.dn.model.inventory.Classroom;

@Service
@Transactional
public class ClassroomService {
	
	@Autowired
	private ClassroomDao classroomDao;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void add(Classroom classroom) {
		System.out.println("Pr�ba zapisu");
		Session session = sessionFactory.getCurrentSession();
		System.out.println("Pobranie sesji zako�czenie powodzeniem");
		session.saveOrUpdate(classroom);
		System.out.println("Zapisanie u�ytkownika zako�czone powodzeniem");
	}
	
	public Classroom getById(long id) {
		return classroomDao.findById(id);
	}
	
	public Classroom getByNumber(int number) {
		return classroomDao.findByNumber(number);
	}
	
	public List<Classroom> getByPagination(int limit, int offset) {
		return classroomDao.findByPagination(limit, offset);
	}
	
	public List<Classroom> getAll() {
		return classroomDao.findAll();
	}
	
	public void update(Classroom classroom) {
		Session session = sessionFactory.getCurrentSession();
		session.update(classroom);
	}
	
	public void deleteById(long id) {
		Classroom classroom = classroomDao.findById(id);
		classroom.setType(null);
		classroomDao.delete(classroom);
	}
	
	
	
	
	
}

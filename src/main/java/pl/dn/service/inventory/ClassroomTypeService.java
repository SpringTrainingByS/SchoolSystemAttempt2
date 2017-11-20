package pl.dn.service.inventory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.inventory.ClassroomTypeDao;
import pl.dn.model.inventory.ClassroomType;

@Service
public class ClassroomTypeService {
	
	@Autowired 
	private ClassroomTypeDao classroomTypeDao;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	private void add(ClassroomType classroomType) {
		Session session = sessionFactory.getCurrentSession();
		session.save(classroomType);
	}
	
	private ClassroomType get(long id) {
		return classroomTypeDao.findById(id);
	}
	
	private List<ClassroomType> getAll() {
		return classroomTypeDao.findAll();
	}
}

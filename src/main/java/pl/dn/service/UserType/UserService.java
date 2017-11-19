package pl.dn.service.UserType;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.dn.dao.userType.UserDao;
import pl.dn.model.userType.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Transactional
	public User add(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
        
		return user;
	}
	
	public User getById(long id) {
		return userDao.findById(id);
	}
	
	@Transactional
	public void update(User user) {
		Session session = sessionFactory.getCurrentSession();
        session.update(user);
	}
	
	public void delete(long id) {
		
		User user = userDao.findById(id);

        user.getContactInfo().getAddress().setVoivodeship(null);
        user.getContactInfo().getAddress().setCity(null);
        user.getContactInfo().getAddress().setStreet(null);
        user.getContactInfo().getAddress().setZipCode(null);

        user.getBornInfo().setCity(null);
        user.getBornInfo().setVoivodeship(null);
		
		userDao.delete(user);
	}
	
	
	
}

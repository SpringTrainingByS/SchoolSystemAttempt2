package pl.dn.user.complementService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.user.User;
import pl.dn.user.UserComplementService;
import pl.dn.user.UserDao;

@Service
public class UserService {

	private UserDao userDao;
//	private SessionFactory sessionFactory;
	private EntityManager em;
	private UserComplementService userCompService;

    @Autowired
	public UserService(UserDao userDao, EntityManager em, UserComplementService userCompService) {
		this.userDao = userDao;
		this.em = em;
		this.userCompService = userCompService;
	}

	@Transactional
	public User add(User user) {
		user = userCompService.fetchPlaceInfo(user);
        em.persist(user);
		return user;
	}


	
	public User getById(long id) {
		return userDao.findById(id);
	}
	
	@Transactional
	public void update(User user) {

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

package pl.dn.user;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.user.complementService.UserComplementService;
import pl.dn.user.validation.base.UserValidService;

@Service
public class UserService {

	private UserDao userDao;
	private EntityManager em;
	private UserComplementService userCompService;
	private UserValidService userValidService;

    @Autowired
	public UserService(UserDao userDao, EntityManager em, UserComplementService userCompService, UserValidService userValidService) {
		this.userDao = userDao;
		this.em = em;
		this.userCompService = userCompService;
        this.userValidService = userValidService;
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

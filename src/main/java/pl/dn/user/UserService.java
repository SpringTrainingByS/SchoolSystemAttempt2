package pl.dn.user;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.user.complementService.UserComplementService;
import pl.dn.user.dataCorrectness.UserChecker;
import pl.dn.user.dataCorrectness.validation.base.UserValidService;

@Service
public class UserService {

	private UserDao userDao;
	private EntityManager em;
	private UserComplementService userCompService;
	private UserChecker userChecker;

    @Autowired
	public UserService(UserDao userDao, EntityManager em, UserComplementService userCompService, UserChecker userChecker) {
		this.userDao = userDao;
		this.em = em;
		this.userCompService = userCompService;
        this.userChecker = userChecker;
    }

	@Transactional
	public User add(User user) throws ValidationException {
    	userChecker.checkUser(user);
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

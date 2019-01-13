package pl.dn.user;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.user.complementService.UserComplementService;
import pl.dn.user.dataCorrectness.UserChecker;
import pl.dn.user.model.UserParams;
import pl.dn.userLogin.LoginInfo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
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

	public User add(User user) throws ValidationException {
    	userChecker.checkUser(user);
		user = userCompService.fetchPlaceInfo(user);
		user.setLoginInfo(createLoginAndPass(user));
		user.getBasicInfo().setStartDate(new Date());
        em.persist(user);
		return user;
	}

	public User getById(long id) {
    	User user = userDao.findById(id);
		System.out.println(user.toString());
		return user;
	}

	public List<User> getByPagination(int limit, int offset) {
        System.out.println("User.Service");
        System.out.println("Offset: " + offset);
        System.out.println("Limit: " + limit);
        return userDao.findByPagination(limit, offset);
    }

	public User update(User user) throws ValidationException {
		userChecker.checkUser(user);
		user = userCompService.fetchPlaceInfo(user);
		user.setLoginInfo(createLoginAndPass(user));
		user.getBasicInfo().setStartDate(new Date());
		em.merge(user);

		return user;
	}

	public List<User> getAll() {
        return userDao.findAllUsers();
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

	public List<User> findByBasicInfo(UserParams userParams, String role) {
    	List<User> users = new ArrayList<User>();

    	System.out.println("rola: " + role);

    	if (!StringUtils.isBlank(role)) {
    		users = userDao.findByBasicInfoAndRole(userParams.getFirstName(), userParams.getLastName(), userParams.getPesel(), role);
		}
		else {
			users = userDao.findByBasicInfo(userParams.getFirstName(), userParams.getLastName(), userParams.getPesel());
		}

    	return users;
	}

	private LoginInfo createLoginAndPass(User user) {
		LoginInfo loginInfo = user.getLoginInfo();
    	loginInfo.setEnabled(true);
		loginInfo.setUsername(user.getContactInfo().getEmail());
		loginInfo.setPassword(user.getBasicInfo().getPesel());

		return loginInfo;
	}
	
	
	
}

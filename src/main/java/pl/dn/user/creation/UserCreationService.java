package pl.dn.user.creation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.security.userRole.UserRole;
import pl.dn.user.User;
import pl.dn.user.UserService;
import pl.dn.userLogin.UserLogin;
import pl.dn.userLogin.UserLoginService;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Service
@Transactional
public class UserCreationService {

    private UserService userService;
    private UserLoginService userLoginService;
    private EntityManager em;

    @Autowired
    public UserCreationService(UserService userService, UserLoginService userLoginService, EntityManager em) {
        this.userService = userService;
        this.userLoginService = userLoginService;
        this.em = em;
    }

    public UserWithRole addUser(UserWithRole userWithRole) throws ValidationException {
        User user = userService.add(userWithRole.getUser());

        UserLogin userLogin = userLoginService.createLoginInfo(user);
        System.out.println("Id u¿ytkownika: " + user.getId());

        UserRole userRole = new UserRole();
        userRole.setRole(userWithRole.getRole());
        userRole.setUserLogin(userLogin);

        userLogin.setUser(user);
        em.persist(userLogin);

        em.persist(userRole);
        userWithRole.setUser(user);

        return userWithRole;
    }

    public UserWithRole update(UserWithRole userWithRole) throws ValidationException {
        User user = userService.update(userWithRole.getUser());
        userWithRole.setUser(user);

        UserRole userRole = userLoginService.linkLoginInfoWithRole(userWithRole.getUser().getId(), userWithRole.getRole());
        em.merge(userRole);

        return userWithRole;
    }


}

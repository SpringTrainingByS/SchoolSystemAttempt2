package pl.dn.userLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.security.role.Role;
import pl.dn.security.userRole.UserRole;
import pl.dn.security.userRole.UserRoleDao;
import pl.dn.user.User;

import java.util.List;

@Service
public class UserLoginService {

    private UserLoginDao userLoginDao;
    private UserRoleDao userRoleDao;

    @Autowired
    public UserLoginService(UserLoginDao userLoginDao, UserRoleDao userRoleDao) {
        this.userLoginDao = userLoginDao;
        this.userRoleDao = userRoleDao;
    }

    public UserLogin createLoginInfo(User user) {

        UserLogin userLogin = new UserLogin();
        userLogin.setEnabled(true);
        userLogin.setUsername(user.getContactInfo().getEmail());
        userLogin.setPassword(user.getBasicInfo().getPesel());

        return userLogin;
    }

    public UserRole linkLoginInfoWithRole(long userId, Role role) {

        UserLogin userLogin = userLoginDao.findByUserId(userId);
        List<UserRole> userRoles = userRoleDao.findByUserLoginId(userLogin.getId());
        UserRole userRole = userRoles.get(0);


        userRole.setRole(role);
        userRole.setUserLogin(userLogin);

        return userRole;
    }

}

package pl.dn.userLogin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.security.role.Role;
import pl.dn.user.User;

@Service
public class UserLoginService {

    private UserLoginDao userLoginDao;

    @Autowired
    public UserLoginService(UserLoginDao userLoginDao) {
        this.userLoginDao = userLoginDao;
    }

    public LoginInfo createLoginInfo(User user) {

        LoginInfo loginInfo = new LoginInfo();
        loginInfo.setEnabled(true);
        loginInfo.setUsername(user.getContactInfo().getEmail());
        loginInfo.setPassword(user.getBasicInfo().getPesel());

        return loginInfo;
    }

}

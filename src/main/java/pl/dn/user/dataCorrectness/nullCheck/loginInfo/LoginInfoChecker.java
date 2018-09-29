package pl.dn.user.dataCorrectness.nullCheck.loginInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.userLogin.LoginInfo;

@Service
public class LoginInfoChecker {

    private StringBuilder stringBuilder;
    private NullMessages nullMessages;

    @Autowired
    public LoginInfoChecker(@Qualifier("LoginInfoNullMessages") NullMessages nullMessages) {
        this.nullMessages = nullMessages;
    }

    public StringBuilder checkNulls(LoginInfo loginInfo, StringBuilder stringBuilder) {
        this.stringBuilder = stringBuilder;

        if (loginInfo == null) {
            this.stringBuilder.append(nullMessages.getLoginInfo());
        }
        else  {
            checkNullsInside(loginInfo);
        }

        return this.stringBuilder;
    }

    public void checkNullsInside(LoginInfo loginInfo) {
        if (loginInfo.getRole() == null) {
            stringBuilder.append(nullMessages.getRole());
        }
    }
}

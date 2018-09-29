package pl.dn.user.dataCorrectness.nullCheck.loginInfo;

import org.springframework.stereotype.Component;

@Component("LoginInfoNullMessages")
public class NullMessages {

    public final String loginInfo = "Brak informacji do logowania.";
    public final String role = "Brak roli dla u¿ytkownika.";

    public String getLoginInfo() {
        return loginInfo;
    }

    public String getRole() {
        return role;
    }
}

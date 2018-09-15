package pl.dn.user.dataCorrectness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.user.User;
import pl.dn.user.dataCorrectness.nullCheck.NullChecker;
import pl.dn.user.dataCorrectness.validation.all.UserValidation;

@Service
public class UserChecker {

    private NullChecker nullChecker;
    private UserValidation userValidation;

    @Autowired
    public UserChecker(NullChecker nullChecker, UserValidation userValidation) {
        this.nullChecker = nullChecker;
        this.userValidation = userValidation;
    }

    public void checkUser(User user) throws ValidationException {
        nullChecker.checkNulls(user);
        userValidation.valid(user);
    }
}

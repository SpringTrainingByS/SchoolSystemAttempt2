package pl.dn.user.validation.base;

import org.springframework.stereotype.Service;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.user.User;

import java.security.SecureRandom;

@Service
public class UserValidService {

    public void validateBeforeAdd() {

    }

    private void checkNulls(User user) {
        StringBuilder message = new StringBuilder();

        message = checkContactInfo(user.getContactInfo(), message);

        if (user.getBasicInfo() == null) {
            message.append(" Brak informacji podstawowych.");
        }
        else {

        }

        if (user.getBornInfo() == null) {

        }
        else {

        }

    }

    public StringBuilder checkContactInfo(UserContactInfo contactInfo, StringBuilder message) {
        if (contactInfo == null) {
            message.append(" Brak informacji kontaktowych. ");
        }
        else {
            message = checkNullsInsdieContactInfo(contactInfo, message);
        }

        return message;
    }

    private StringBuilder checkNullsInsdieContactInfo(UserContactInfo contactInfo, StringBuilder message) {
        return message;
    }

//    private String checkBasicInfo(BasicInfo basicInfo, StringBuilder message) {
//        if ()
//    }
}

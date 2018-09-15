package pl.dn.user.dataCorrectness.nullCheck;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.user.User;
import pl.dn.user.dataCorrectness.nullCheck.basicInfo.BasicInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.BornInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.contactInfo.ContactInfoChecker;

@Service
public class NullChecker {

    private BasicInfoChecker basicInfoChecker;
    private BornInfoChecker bornInfoChecker;
    private ContactInfoChecker contactInfoChecker;

    @Autowired
    public NullChecker(BasicInfoChecker basicInfoChecker, BornInfoChecker bornInfoChecker, ContactInfoChecker contactInfoChecker) {
        this.basicInfoChecker = basicInfoChecker;
        this.bornInfoChecker = bornInfoChecker;
        this.contactInfoChecker = contactInfoChecker;
    }

    public void checkNulls(User user) throws ValidationException {
        StringBuilder message = new StringBuilder();

        if (user == null) {
            message.append("Brak danych.");
        }
        else {
            message = checkInside(user, message);
        }

        String resultMsg = message.toString();

        if (!StringUtils.isEmpty(resultMsg)) {
            throw new ValidationException(resultMsg);
        }

    }

    private StringBuilder checkInside(User user, StringBuilder message) {
        message = basicInfoChecker.checkNulls(user.getBasicInfo(), message);
        message = contactInfoChecker.checkContactInfo(user.getContactInfo(), message);
        message = bornInfoChecker.checkNulls(user.getBornInfo(), message);

        return message;
    }

}

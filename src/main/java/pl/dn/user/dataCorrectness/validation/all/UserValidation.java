package pl.dn.user.dataCorrectness.validation.all;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.exception.ValidationException;
import pl.dn.user.User;
import pl.dn.user.dataCorrectness.validation.basicInfo.BasicInfoValid;
import pl.dn.user.dataCorrectness.validation.bornInfo.BornInfoValid;
import pl.dn.user.dataCorrectness.validation.contactInfo.ContactInfoValid;

@Service
public class UserValidation {

    private BasicInfoValid basicInfoValid;
    private ContactInfoValid contactInfoValid;
    private BornInfoValid bornInfoValid;
    private ValidMessages validMessages;

    @Autowired
    public UserValidation(BasicInfoValid basicInfoValid, ContactInfoValid contactInfoValid, BornInfoValid bornInfoValid, ValidMessages validMessages) {
        this.basicInfoValid = basicInfoValid;
        this.contactInfoValid = contactInfoValid;
        this.bornInfoValid = bornInfoValid;
        this.validMessages = validMessages;
    }

    public void valid(User user) throws ValidationException {

        StringBuilder message = new StringBuilder();

        StringBuilder basicInfoMessage = basicInfoValid.valid(user.getBasicInfo());
        StringBuilder contactInfoMessage = contactInfoValid.valid(user.getContactInfo());
        StringBuilder bornInfoMessage = bornInfoValid.valid(user.getBornInfo());

        if (basicInfoMessage.length() > 0) {
            message.append(validMessages.basicInfo);
            message.append(basicInfoMessage);
        }

        if (contactInfoMessage.length() > 0) {
            message.append(validMessages.contactInfo);
            message.append(contactInfoMessage);
        }

        if (bornInfoMessage.length() > 0) {
            message.append(validMessages.bornInfo);
            message.append(bornInfoMessage);
        }

        if (message.length() > 0) {
            String result = message.toString();
            throw new ValidationException(result);
        }

    }



}

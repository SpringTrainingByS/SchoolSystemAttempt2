package pl.dn.user.dataCorrectness.nullCheck.basicInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BasicInfoNullMessages")
public class NullMessages {

    private final String basicInfo = "Brak informacji podstawowych.";
    private final String firstName = "Brak imienia.";
    private final String surname = "Brak nazwiska.";
    private final String pesel = "Brak numeru pesel.";

    public String getBasicInfo() {
        return basicInfo;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }
}

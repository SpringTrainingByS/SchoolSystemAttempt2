package pl.dn.user.dataCorrectness.validation.basicInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("BasicInfoInvalidMessages")
public class InvalidMessages {

    private final String firstName = ", imiê";
    private final String lastName = ", nazwisko";
    private final String pesel = ", pesel";

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPesel() {
        return pesel;
    }
}

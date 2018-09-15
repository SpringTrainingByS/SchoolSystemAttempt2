package pl.dn.user.dataCorrectness.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

@Service
public class ValidationService {

    private ValidationPatterns validPatterns;

    @Autowired
    public ValidationService(ValidationPatterns validPatterns) {
        this.validPatterns = validPatterns;
    }

    public boolean validName(String name) {
        return name.matches(validPatterns.getName());
    }

    public boolean validNameStartGreat(String name) {
        return name.matches(validPatterns.getNameStartGreat());
    }

    public boolean validZipode(String zipCode) {
        return zipCode.matches(validPatterns.getZipCode());
    }

    public boolean validNumber(String number) {
        return number.matches(validPatterns.getNumber());
    }

    public boolean validPhoneNumber(String phoneNumber) {
        return phoneNumber.matches(validPatterns.getPhoneNumber());
    }

    public boolean validPesel(String pesel) {
        return pesel.matches(validPatterns.getPesel());
    }

    public boolean validEmail(String email) {
        return email.matches(validPatterns.getEmail());
    }

}

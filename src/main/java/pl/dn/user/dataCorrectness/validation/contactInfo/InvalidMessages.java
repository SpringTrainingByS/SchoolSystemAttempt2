package pl.dn.user.dataCorrectness.validation.contactInfo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("ContactInfoInvalidMessages")
public class InvalidMessages {
    public final String email = ", adres email";
    public final String phoneNumber = ", numer telefonu";
    public final String houseNumber = ", numer domu";
    public final String apratmentNumber = ", numer mieszkania";
    public final String zipCode = ", kod pocztowy";
    public final String city = ", miasto";
    public final String street = ", ulica";
    public final String voivodeship = ", województwo";
}

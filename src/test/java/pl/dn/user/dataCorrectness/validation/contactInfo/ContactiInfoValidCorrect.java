package pl.dn.user.dataCorrectness.validation.contactInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.security.UserRoleOnly;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import static org.junit.Assert.assertEquals;

public class ContactiInfoValidCorrect {

    private ContactInfoValid contactInfoValid;
    private InvalidMessages messages;

    @Before()
    public void prepareTest() {
        messages = new InvalidMessages();
        contactInfoValid = new ContactInfoValid(new ValidationService(new ValidationPatterns()), messages);
    }

    @Test
    public void testValidWhenContactInfoIsCorrectShouldReturnNoMsg() {
        UserContactInfo contactInfo = prepareContactInfo();

        String result = contactInfoValid.valid(contactInfo).toString();
        assertEquals("msg validation for ccontact info should contain nothing",
                "",
                result);
    }

    private UserContactInfo prepareContactInfo() {
        UserContactInfo contactInfo = new UserContactInfo();

        contactInfo.setPhoneNumber("502147963");
        contactInfo.setEmail("scorpion7458@gmail.com");
        contactInfo.setAddress(prepareAddress());

        return contactInfo;
    }

    private Address prepareAddress() {
        Address address = new Address();

        address.setHouseNamber(5);
        address.setApartmentNumber(6);
        address.setZipCode(new ZipCode("21-307"));
        address.setCity(new City("G¹siory"));
        address.setStreet(new Street("Orzechowa"));
        address.setVoivodeship(new Voivodeship("lubelskie"));

        return address;
    }


}

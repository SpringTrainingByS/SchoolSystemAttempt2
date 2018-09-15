package pl.dn.user.dataCorrectness.validation.contactInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import static org.junit.Assert.assertEquals;

public class ContactInfoValidInvalidData {

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
        System.out.println(result);

        assertEquals("msg validation for contact info should contain wrong number information",
                true,
                result.contains(messages.phoneNumber));

        assertEquals("msg validation for contact info should contain wrong email information",
                true,
                result.contains(messages.email));

        assertEquals("msg validation for contact info should contain wrong house number information",
                true,
                result.contains(messages.houseNumber));

        assertEquals("msg validation for contact info should contain wrong apartment number information",
                true,
                result.contains(messages.apratmentNumber));

        assertEquals("msg validation for contact info should contain wrong apartment zip code information",
                true,
                result.contains(messages.zipCode));

        assertEquals("msg validation for contact info should contain wrong city name information",
                true,
                result.contains(messages.city));

        assertEquals("msg validation for contact info should contain wrong street name information",
                true,
                result.contains(messages.street));

        assertEquals("msg validation for contact info should contain wrong voivodeship number information",
                true,
                result.contains(messages.voivodeship));
    }

    private UserContactInfo prepareContactInfo() {
        UserContactInfo contactInfo = new UserContactInfo();

        contactInfo.setPhoneNumber("502147963l");
        contactInfo.setEmail("scorpion7458@gmail.com343");
        contactInfo.setAddress(prepareAddress());

        return contactInfo;
    }

    private Address prepareAddress() {
        Address address = new Address();

        address.setHouseNamber(456564464);
        address.setApartmentNumber(79897987);
        address.setZipCode(new ZipCode("21--307"));
        address.setCity(new City("G¹siory5"));
        address.setStreet(new Street("Orzechowa4"));
        address.setVoivodeship(new Voivodeship("Lubelskie"));

        return address;
    }

}

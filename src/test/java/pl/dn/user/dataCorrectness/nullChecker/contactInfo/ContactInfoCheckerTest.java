package pl.dn.user.dataCorrectness.nullChecker.contactInfo;

import org.junit.Test;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.user.dataCorrectness.nullCheck.contactInfo.ContactInfoChecker;

import static org.junit.Assert.assertEquals;


public class ContactInfoCheckerTest {

    private ContactInfoChecker contactInfoChecker;



    @Test
    public void testCheckContatctInfoShuldReturnStringBuilderWithoutString() {
        UserContactInfo userContactInfo = prepareNotNullContactInfo();

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = contactInfoChecker.checkContactInfo(userContactInfo, stringBuilder);
        System.out.println(stringBuilder.toString());

        assertEquals("should return empty string", "", stringBuilder.toString());
    }

    public UserContactInfo prepareNotNullContactInfo() {
        UserContactInfo contactInfo = new UserContactInfo();

        contactInfo.setEmail("");
        contactInfo.setPhoneNumber("");
        contactInfo.setAddress(new Address());

        contactInfo.getAddress().setZipCode(new ZipCode());
        contactInfo.getAddress().setHouseNamber(5);
        contactInfo.getAddress().setApartmentNumber(6);
        contactInfo.getAddress().setCity(new City());
        contactInfo.getAddress().setStreet(new Street());
        contactInfo.getAddress().setZipCode(new ZipCode());
        contactInfo.getAddress().setVoivodeship(new Voivodeship());

        return contactInfo;
    }

}

package pl.dn.user.dataCorrectness.nullChecker.contactInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;
import pl.dn.user.dataCorrectness.nullCheck.contactInfo.ContactInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.contactInfo.NullMessages;

import static org.junit.Assert.assertEquals;

public class AllAddressDataNull {

    private ContactInfoChecker contactInfoChecker;

    private NullMessages nullMessages;

    @Before
    public void prepareTest() {
        nullMessages = new NullMessages();
    }

    @Test
    public void checkNotNullShouldReturnInfoAboutAddressIsNull() {
        UserContactInfo contactInfo = new UserContactInfo();
        contactInfo.setEmail("");
        contactInfo.setPhoneNumber("");

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = contactInfoChecker.checkContactInfo(contactInfo, stringBuilder);

        String resultMsg = stringBuilder.toString();
        System.out.println(resultMsg);

        assertEquals("should contain house number null msg",
                true,
                resultMsg.contains(nullMessages.getAddress()));
    }

    @Test
    public void checkNotNullShouldReturnInfoAboutAddressDetailsIsNull() {
        UserContactInfo contactInfo = prepareNullAddressDetails();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = contactInfoChecker.checkContactInfo(contactInfo, stringBuilder);

        String nullResultMsg = stringBuilder.toString();

        System.out.println(nullResultMsg);

        assertEquals("should contain house number null msg",
                true,
                nullResultMsg.contains(nullMessages.getHouseNumber()));

        assertEquals("should contain apartment number null msg",
                true,
                nullResultMsg.contains(nullMessages.getApartmentNumber()));

        assertEquals("should contain city null msg",
                true,
                nullResultMsg.contains(nullMessages.getCity()));

        assertEquals("should contain zipCode null msg",
                true,
                nullResultMsg.contains(nullMessages.getZipCode()));

        assertEquals("should contain voivodeshipnull msg",
                true,
                nullResultMsg.contains(nullMessages.getVoivodeship()));

        assertEquals("should contain street null msg",
                true,
                nullResultMsg.contains(nullMessages.getStreet()));
        ;
    }

    public UserContactInfo prepareNullAddressDetails() {
        UserContactInfo contactInfo = new UserContactInfo();

        contactInfo.setEmail("");
        contactInfo.setPhoneNumber("");
        contactInfo.setAddress(new Address());

        return contactInfo;
    }

}

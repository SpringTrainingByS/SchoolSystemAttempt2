package pl.dn.user.nullChecker.contactInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.user.User;
import pl.dn.user.nullCheck.contactInfo.ContactInfoChecker;
import pl.dn.user.nullCheck.contactInfo.NullMessages;

import static org.junit.Assert.assertEquals;

public class ContactInfoDataIsNull {

    private ContactInfoChecker contactInfoChecker;

    private NullMessages nullMessages;

    @Before
    public void prepareTest() {
        nullMessages = new NullMessages();
    }

    @Test
    public void testCheckNullShouldReturnMsgIsContactInfoIsNull() {
        User user = new User();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = contactInfoChecker.checkContactInfo(user.getContactInfo(), stringBuilder);
        String result = stringBuilder.toString();

        System.out.println(result);

        assertEquals("should contain contact info null msg",
                true,
                result.contains(nullMessages.getContactInfo()));
    }

    @Test
    public void testCheckNullShouldReturnMsgAboutContactInfoDetailsIsNull() {
        UserContactInfo contactInfo = new UserContactInfo();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = contactInfoChecker.checkContactInfo(contactInfo, stringBuilder);
        String result = stringBuilder.toString();

        assertEquals("should contain email null msg",
                true,
                result.contains(nullMessages.getEmail()));

        assertEquals("should contain phone number null msg",
                true,
                result.contains(nullMessages.getPhoneNumber()));
    }

}

package pl.dn.user.nullChecker.basicInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.user.User;
import pl.dn.user.nullCheck.basicInfo.BasicInfoChecker;
import pl.dn.user.nullCheck.basicInfo.NullMessages;

import static org.junit.Assert.assertEquals;

public class TestBasicInfoWhenIsNullAndInsideIsNull {

    private NullMessages nullMessages;

    private BasicInfoChecker checker;

    @Before
    public void prepareTest() {
        nullMessages = new NullMessages();
        checker = new BasicInfoChecker();
    }

    @Test
    public void testCheckNullWhenBasicInfoIsNullShouldReturnMsgAboutNull() {
        StringBuilder stringBuilder = new StringBuilder();
        User user = new User();

        stringBuilder = checker.checkNulls(user.getBasicInfo(), stringBuilder);


        assertEquals("should contain nothing", true,
                stringBuilder.toString().contains(nullMessages.getBasicInfo()));
    }

    @Test
    public void testCheckNullWhenBasicInfoDetailsIsNullShouldReturnMsgAboutNull() {
        StringBuilder stringBuilder = new StringBuilder();
        BasicInfo basicInfo = new BasicInfo();

        stringBuilder = checker.checkNulls(basicInfo, stringBuilder);
        String result = stringBuilder.toString();

        System.out.println(result);

        assertEquals("should contain first name null msg",
                true,
                result.contains(nullMessages.getFirstName()));

        assertEquals("should contain last name null msg",
                 true,
                result.contains(nullMessages.getSurname()));

        assertEquals("should contain pesel null msg",
                true,
                result.contains(nullMessages.getPesel()));

    }

}

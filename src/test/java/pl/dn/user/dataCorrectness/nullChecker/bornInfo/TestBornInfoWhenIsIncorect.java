package pl.dn.user.dataCorrectness.nullChecker.bornInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.user.User;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.BornInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.NullMessages;

import static org.junit.Assert.assertEquals;

public class TestBornInfoWhenIsIncorect {

    private BornInfoChecker checker;

    private NullMessages nullMsgs;

    @Before()
    public void prepareTest() {
        checker = new BornInfoChecker();

        nullMsgs = new NullMessages();
    }

    @Test
    public void testBornInfoWhenIsNullShouldReturnMsgAboutNull() {
        User user = new User();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = checker.checkNulls(user.getBornInfo(), stringBuilder);

        assertEquals("should contain nothing", true,
                stringBuilder.toString().contains(nullMsgs.getBornInfo()));
    }

    @Test
    public void testBornInfoDetailsWhenIsNullShouldReturnMsgAboutNulls() {
        UserBornInfo bornInfo = new UserBornInfo();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = checker.checkNulls(bornInfo, stringBuilder);
        String result = stringBuilder.toString();

        assertEquals("should contain born date null msg",
                true,
                stringBuilder.toString().contains(nullMsgs.getDate()));

        assertEquals("should contain born city null msg",
                true,
                stringBuilder.toString().contains(nullMsgs.getCity()));

        assertEquals("should contain born voivodeship null msg",
                true,
                stringBuilder.toString().contains(nullMsgs.getVoivodeship()));
    }


}

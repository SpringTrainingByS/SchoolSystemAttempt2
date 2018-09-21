package pl.dn.user.dataCorrectness.nullChecker.basicInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.user.dataCorrectness.nullCheck.basicInfo.BasicInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.basicInfo.NullMessages;

import static org.junit.Assert.assertEquals;

public class BasicInfoCheckerCorrect {

    private NullMessages nullMessages;

    private BasicInfoChecker checker;

    @Before
    public void prepareTest() {
        nullMessages = new NullMessages();
        checker = new BasicInfoChecker(new NullMessages());
    }

    @Test
    public void testCheckNullsShouldReturnMsgIsBasicInfoIsNull() {
        StringBuilder stringBuilder = new StringBuilder();
        BasicInfo basicInfo = prepareCorrectBasicInfo();

        stringBuilder = checker.checkNulls(basicInfo, stringBuilder);
        String result = stringBuilder.toString();

        assertEquals("should contain nothing", "",
                result);
    }

    public BasicInfo prepareCorrectBasicInfo() {
        BasicInfo basicInfo = new BasicInfo();

        basicInfo.setPesel("78945645789");
        basicInfo.setFirstName("Dariusz");
        basicInfo.setLastName("Nurzyñski");

        return basicInfo;
    }


}

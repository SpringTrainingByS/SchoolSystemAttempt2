package pl.dn.user.dataCorrectness.validation.basicInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;
import pl.dn.user.dataCorrectness.validation.basicInfo.BasicInfoValid;
import pl.dn.user.dataCorrectness.validation.basicInfo.InvalidMessages;

import static org.junit.Assert.assertEquals;

public class BasicInfoValidTest {

    private BasicInfoValid basicInfoValid;
    private InvalidMessages invalidMessages;

    @Before()
    public void prepareTest() {
        invalidMessages = new InvalidMessages();
        basicInfoValid = new BasicInfoValid(new ValidationService(new ValidationPatterns()), invalidMessages);
    }

    @Test
    public void testValidWhenDataIsCorrectShouldReturnNoMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        BasicInfo basicInfo = prepareBasicInfo();

        String result = basicInfoValid.valid(basicInfo).toString();

        assertEquals("result of basic info validation, should contain ''", "",
                result);

    }

    @Test
    public void testValidWhenDataIsIncorrectShouldReturnMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        BasicInfo basicInfo = prepareInvaliBasicInfo();

        String result = basicInfoValid.valid(basicInfo).toString();

        assertEquals("should contains message about first name invalid", true,
                result.contains(invalidMessages.getFirstName()));

        assertEquals("should contains message about second name invalid", true,
                result.contains(invalidMessages.getLastName()));

        assertEquals("should contains message about pesel invalid", true,
                result.contains(invalidMessages.getPesel()));

    }

    private BasicInfo prepareBasicInfo() {
        BasicInfo basicInfo = new BasicInfo();

        basicInfo.setFirstName("Dariusz");
        basicInfo.setLastName("Nurzyñski");
        basicInfo.setPesel("94785621345");

        return basicInfo;
    }

    private BasicInfo prepareInvaliBasicInfo() {
        BasicInfo basicInfo = new BasicInfo();

        basicInfo.setFirstName("Dariusz56");
        basicInfo.setLastName("nurzyñski");
        basicInfo.setPesel("9478p5621345");

        return basicInfo;
    }


}

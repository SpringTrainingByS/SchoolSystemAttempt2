package pl.dn.user.dataCorrectness.validation.bornInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class BornInfoValidInvalidDataTest {

    private BornInfoValid bornInfoValid;
    private InvalidMessages messages;

    @Before()
    public void prepareTest() {
        messages = new InvalidMessages();
        bornInfoValid = new BornInfoValid(new ValidationService(new ValidationPatterns()), messages);
    }

    @Test
    public void testBornInfoWhenIsCorrectShouldReturnNoMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        UserBornInfo bornInfo = prepareCorrectBornInfo();

        String result = bornInfoValid.valid(bornInfo).toString();

        System.out.println(result);

        assertEquals(
                "validation message shuolud contain city invalid msg",
                true,
                result.contains(messages.getCity()));

        assertEquals(
                "validation message shuolud contain voivodeship invalid msg",
                true,
                result.contains(messages.getVoivodeship()));

        assertEquals(
                "validation message shuolud contain day of month invalid msg",
                true,
                result.contains(messages.getBornDay()));

    }

    private UserBornInfo prepareCorrectBornInfo() {
        UserBornInfo bornInfo = new UserBornInfo();

        bornInfo.setCity(new City("G¹si3ory"));
        bornInfo.setVoivodeship(new Voivodeship("Lubelskie"));
        Date date = new Date();
        date.setMonth(2);
        date.setDate(30);
        date.setYear(2016);
        bornInfo.setBornDate(date);

        return bornInfo;
    }

}

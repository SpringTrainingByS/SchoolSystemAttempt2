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

public class BornInfoValidTest {

    private BornInfoValid bornInfoValid;
    private InvalidMessages messages;

    @Before()
    public void prepareTest() {
        bornInfoValid = new BornInfoValid(new ValidationService(new ValidationPatterns()), messages);
    }

    @Test
    public void testBornInfoWhenIsCorrectShouldReturnNoMessage() {
        StringBuilder stringBuilder = new StringBuilder();
        UserBornInfo bornInfo = prepareCorrectBornInfo();

        String result = bornInfoValid.valid(bornInfo).toString();

        assertEquals(
                "validation message shuolud contain nothind",
                true,
                result.equals(""));

    }

    private UserBornInfo prepareCorrectBornInfo() {
        UserBornInfo bornInfo = new UserBornInfo();

        bornInfo.setCity(new City("G¹siory"));
        bornInfo.setVoivodeship(new Voivodeship("lubelskie"));
        Date date = new Date();
        date.setMonth(2);
        date.setDate(21);
        date.setYear(2000);
        bornInfo.setBornDate(date);

        return bornInfo;
    }


}

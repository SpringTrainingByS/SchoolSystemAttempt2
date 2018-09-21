package pl.dn.user.dataCorrectness.nullChecker.bornInfo;

import org.junit.Before;
import org.junit.Test;
import pl.dn.bornInfo.UserBornInfo;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.BornInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.NullMessages;

import java.util.Date;

import static org.junit.Assert.assertEquals;

public class TestBornInfoWhenIsCorrect {

    private BornInfoChecker checker;

    @Before()
    public void prepareTest() {
        checker = new BornInfoChecker(new NullMessages());
    }

    @Test
    public void testBornInfoWhenCorrectShouldReturnEmptyStringAsOk() {
        UserBornInfo userBornInfo = prepareBornInfo();
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder = checker.checkNulls(userBornInfo, stringBuilder);

        assertEquals("should contain nothing", "",
                stringBuilder.toString());
    }

    public UserBornInfo prepareBornInfo() {
        UserBornInfo userBornInfo = new UserBornInfo();

        userBornInfo.setVoivodeship(new Voivodeship());
        userBornInfo.setCity(new City());
        userBornInfo.setBornDate(new Date());

        return userBornInfo;
    }

}

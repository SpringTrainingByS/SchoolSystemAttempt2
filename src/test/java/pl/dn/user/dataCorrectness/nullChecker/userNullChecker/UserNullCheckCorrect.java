package pl.dn.user.dataCorrectness.nullChecker.userNullChecker;

import org.junit.Before;
import org.junit.Test;
import pl.dn.exception.ValidationException;
import pl.dn.user.User;
import pl.dn.user.dataCorrectness.nullCheck.NullChecker;
import pl.dn.user.dataCorrectness.nullCheck.basicInfo.BasicInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.basicInfo.NullMessages;
import pl.dn.user.dataCorrectness.nullCheck.bornInfo.BornInfoChecker;
import pl.dn.user.dataCorrectness.nullCheck.contactInfo.ContactInfoChecker;

import static org.junit.Assert.assertEquals;

public class UserNullCheckCorrect {

    private NullChecker checker;

    private UserCheckerTestPreparationCorrectData preparation;

    @Before()
    public void prepareTest() {
        checker = new NullChecker(new BasicInfoChecker(new NullMessages()),
                new BornInfoChecker(new pl.dn.user.dataCorrectness.nullCheck.bornInfo.NullMessages()),
                new ContactInfoChecker(new pl.dn.user.dataCorrectness.nullCheck.contactInfo.NullMessages()));

        preparation = new UserCheckerTestPreparationCorrectData();
    }

    @Test
    public void testCheckNullWhenUserDataIsCorrect() {
        User user = preparation.prepareCorrectUser();

        boolean isUserCorrect = true;

        try {
            checker.checkNulls(user);
        }
        catch (ValidationException e) {
            System.out.println(e.getMessage());
            isUserCorrect = false;
        }

        assertEquals("should isUserCorrect be true", true, isUserCorrect);
    }

}

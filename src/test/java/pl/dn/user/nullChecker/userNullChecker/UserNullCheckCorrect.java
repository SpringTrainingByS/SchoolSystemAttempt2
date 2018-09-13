package pl.dn.user.nullChecker.userNullChecker;

import org.junit.Before;
import org.junit.Test;
import pl.dn.exception.ValidationException;
import pl.dn.user.User;
import pl.dn.user.nullCheck.NullChecker;
import pl.dn.user.nullCheck.basicInfo.BasicInfoChecker;
import pl.dn.user.nullCheck.bornInfo.BornInfoChecker;
import pl.dn.user.nullCheck.contactInfo.ContactInfoChecker;

import static org.junit.Assert.assertEquals;

public class UserNullCheckCorrect {

    private NullChecker checker;

    private UserCheckerTestPreparationCorrectData preparation;

    @Before()
    public void prepareTest() {
        checker = new NullChecker(new BasicInfoChecker(), new BornInfoChecker(), new ContactInfoChecker());
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

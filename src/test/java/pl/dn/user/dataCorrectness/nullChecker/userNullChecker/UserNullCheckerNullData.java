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
import pl.dn.user.dataCorrectness.nullCheck.loginInfo.LoginInfoChecker;

import static org.junit.Assert.assertEquals;

public class UserNullCheckerNullData {

    private NullChecker checker;

    @Before
    public void prepareTest() {
        checker = new NullChecker(new BasicInfoChecker(new NullMessages()),
                new BornInfoChecker(new pl.dn.user.dataCorrectness.nullCheck.bornInfo.NullMessages()),
                new ContactInfoChecker(new pl.dn.user.dataCorrectness.nullCheck.contactInfo.NullMessages()),
                new LoginInfoChecker(new pl.dn.user.dataCorrectness.nullCheck.loginInfo.NullMessages()));
    }

    @Test
    public void testCheckNullsWhenUserIsNullShouldThrowValidationExcption() {

        User user = null;
        boolean isUserCorrect = true;
        String message = "";

        try {
            checker.checkNulls(user);
        }
        catch (ValidationException e) {
            isUserCorrect = false;
            message = e.getMessage();
        }

        assertEquals("isUserCorrect should be false", false, isUserCorrect);
        assertEquals("message should contain msg about no user data",
                true,
                message.contains("Brak danych."));
    }

    @Test
    public void testCheckNullsWhenUserDataInsideIsNullShouldThrowValidationExcption() {

        User user = new User();
        boolean isUserCorrect = true;
        String message = "";

        try {
            checker.checkNulls(user);
        }
        catch (ValidationException e) {
            isUserCorrect = false;
            message = e.getMessage();
        }

        System.out.println(message);

        assertEquals("isUserCorrect should be false", false, isUserCorrect);

        assertEquals("message should contain msg about no basic info data",
                true,
                message.contains("Brak informacji podstawowych."));

        assertEquals("message should contain msg about no contact info data",
                true,
                message.contains("Brak informacji kontaktowych."));

        assertEquals("message should contain msg about no born info data",
                true,
                message.contains("Brak informacji narodzin."));
    }
}
package pl.dn.user.dataCorrectness.validation.patterns;

import org.junit.Before;
import org.junit.Test;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import static org.junit.Assert.assertEquals;

public class ValidNameStartCapital {
    private ValidationService validService;

    @Before
    public void setUP() {
        validService = new ValidationService(new ValidationPatterns());
    }

    @Test
    public void testValidNameStartCapitalShouldReturnTrue() {
        String name = "Nurzyñski";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("Nurzyñski should return true",true, result);
    }

    @Test
    public void testValidTwoPartedNameStartCapitalShouldReturnTrue() {
        String name = "Nurzyñski-Chrobry";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("Nurzyñski-Chrobory should return true", true, result);
    }

    @Test
    public void testValidTwoPartedNameStartCapitalWithSpaceBetweenShouldReturnTrue() {
        String name = "Nurzyñski Chrobry";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("Nurzyñski Chrobry should return true", true, result);
    }

    @Test
    public void testValidNameWithDigitsShouldReturnFalse() {
        String name = "Nurzy456ñski45646";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("Nurzy456ñski45646 should return false",false, result);
    }

    @Test
    public void testValidNameWithWhiteSpaceAheadShouldReturnFalse() {
        String name = " Rolna";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\" rolna\" should return false",false, result);
    }

    @Test
    public void testValidNameEndingWhiteSpaceShouldReturnFalse() {
        String name = "Rolna ";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\"rolna \" should return false",false, result);
    }

    @Test
    public void testValidNameWithWhiteSpaceOnlyShouldReturnFalse() {
        String name = " ";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\" \" should return false",false, result);
    }


    @Test
    public void testValidNameSecondPartStartGreaterShouldReturnFalse() {
        String name = "rolna-Rolna";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\"rolna-Rolna\" should return false",false, result);
    }

    @Test
    public void testNormalNameWithSepartorShouldReturnFalse() {
        String name = "rolna-rolna";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\"rolna-rolna\" should return false",false, result);
    }

    @Test
    public void testTwoPartedNameSepartedByWhiteSpaceWithShouldReturnFalse() {
        String name = "rolna rolna";
        boolean result = validService.validNameStartGreat(name);
        assertEquals("\"rolna rolna\" should return true",false, result);
    }
}

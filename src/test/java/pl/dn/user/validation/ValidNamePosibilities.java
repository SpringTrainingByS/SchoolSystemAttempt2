package pl.dn.user.validation;

import org.junit.Before;
import org.junit.Test;
import pl.dn.user.validation.base.ValidationPatterns;

import static org.junit.Assert.assertEquals;


public class ValidNamePosibilities {

    private ValidationService validService;

    @Before
    public void setUP() {
        validService = new ValidationService(new ValidationPatterns());
    }

    @Test
    public void testValidNameStartCapitalShouldReturnFalse() {
        String name = "Nurzy�ski";
        boolean result = validService.validName(name);
        assertEquals("Nurzy�ski should return false",false, result);
    }

    @Test
    public void testValidTwoPartedNameStartCapitalShouldReturnFalse() {
        String name = "Nurzy�ski-Chrobry";
        boolean result = validService.validName(name);
        assertEquals("Nurzy�ski-Chrobory should return false",false, result);
    }

    @Test
    public void testValidTwoPartedNameStartCapitalWithSpaceBetweenShouldReturnFalse() {
        String name = "Nurzy�ski Chrobry";
        boolean result = validService.validName(name);
        assertEquals("Nurzy�ski Chrobry should return false",false, result);
    }

    @Test
    public void testValidNameWithDigitsShouldReturnFalse() {
        String name = "Nurzy456�ski45646";
        boolean result = validService.validName(name);
        assertEquals("Nurzy456�ski45646 should return false",false, result);
    }

    @Test
    public void testValidNameWithWhiteSpaceAheadShouldReturnFalse() {
        String name = " rolna";
        boolean result = validService.validName(name);
        assertEquals("\" rolna\" should return false",false, result);
    }

    @Test
    public void testValidNameEndingWhiteSpaceShouldReturnFalse() {
        String name = "rolna ";
        boolean result = validService.validName(name);
        assertEquals("\"rolna \" should return false",false, result);
    }

    @Test
    public void testValidNameWithWhiteSpaceOnlyShouldReturnFalse() {
        String name = " ";
        boolean result = validService.validName(name);
        assertEquals("\" \" should return false",false, result);
    }


    @Test
    public void testValidNameSecondPartStartGreaterShouldReturnFalse() {
        String name = "rolna-Rolna";
        boolean result = validService.validName(name);
        assertEquals("\"rolna-Rolna\" should return false",false, result);
    }

    @Test
    public void testNormalNameShouldReturnTrue() {
        String name = "rolna";
        boolean result = validService.validName(name);
        assertEquals("\"rolna\" should return true",true, result);
    }

    @Test
    public void testNormalNameWithSepartorShouldReturnTrue() {
        String name = "rolna-rolna";
        boolean result = validService.validName(name);
        assertEquals("\"rolna-rolna\" should return true",true, result);
    }

    @Test
    public void testTwoPartedNameSepartedByWhiteSpaceWithShouldReturnTrue() {
        String name = "rolna rolna";
        boolean result = validService.validName(name);
        assertEquals("\"rolna rolna\" should return true",true, result);
    }

}

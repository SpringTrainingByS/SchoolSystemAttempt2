package pl.dn.user.dataCorrectness.validation.patterns;

import org.junit.Before;
import org.junit.Test;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

import static org.junit.Assert.assertEquals;

public class ValidZipCode {

    private ValidationService validationService;

    @Before
    public void setUp() {
        validationService = new ValidationService(new ValidationPatterns());
    }

    @Test
    public void testNormalZipCodeShuouldReturnTrue() {
        String zipCode = "21-307";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21-307\" should return true", true, result);
    }

    @Test
    public void testZipCodeWithourSeparatorShouldReturnFalse() {
        String zipCode = "21307";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21307\" should return true", false, result);
    }

    @Test
    public void testSecondPartToShortShouldReturnFalse() {
        String zipCode = "21-30";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21-30\" should return true", false, result);
    }

    @Test
    public void testFirstPartToShortShouldReturnFalse() {
        String zipCode = "2-307";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"2-307\" should return true", false, result);
    }

    @Test
    public void testBothPartToShortShouldReturnFalse() {
        String zipCode = "2-37";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"2-07\" should return true", false, result);
    }

    @Test
    public void testZipCodeContainLettersShouldReturnFalse() {
        String zipCode = "21-30aa";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21-30aa\" should return true", false, result);
    }

    @Test
    public void testZipCodeWithWhiteSpaceAheadShouldReturnFalse() {
        String zipCode = " 21-307";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\" 21-307\" should return true", false, result);
    }

    @Test
    public void testZipCodeWithWhiteSpaceEndingShouldReturnFalse() {
        String zipCode = "21-307 ";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21-307 \" should return true", false, result);
    }

    @Test
    public void testZipCodeWithWhiteSpaceInsidehouldReturnFalse() {
        String zipCode = "21 -307";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\"21 -307\" should return true", false, result);
    }

    @Test
    public void testWhiteSpaceShouldReturnFalse() {
        String zipCode = " ";
        boolean result = validationService.validZipode(zipCode);
        assertEquals("\" \" should return true", false, result);
    }
}

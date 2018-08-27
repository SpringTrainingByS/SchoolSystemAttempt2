package pl.dn.schoolClassOrganization.prefix;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dn.base.BaseDetailService;
import pl.dn.base.BaseDetailValidator;
import pl.dn.exception.ValidationException;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefix;
import pl.dn.schoolClassOrganization.details.prefix.ClassPrefixDao;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.properties")
public class BaseDetailValidatorTest {

    @Autowired
    private BaseDetailValidator bdv;

    @Autowired
    private ClassPrefixDao cpd;

    private String[] validationPatterns = {
            "^[\\p{L}]+$"};


    @Test
    public void TestValidateBeforeAdd() {
        System.out.println("TestValidateBeforeAdd");
        ClassPrefix cp = new ClassPrefix();
        cp.setName("z");
        try {
            bdv.validateBeforeAdd(cp, cpd, validationPatterns);
        } catch (ValidationException e) {
            e.printStackTrace();
        }
    }
}

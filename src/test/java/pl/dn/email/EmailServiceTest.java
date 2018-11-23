package pl.dn.email;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan("pl.dn.user.complementService")
@TestPropertySource(locations="classpath:test.properties")
public class EmailServiceTest {

    @Autowired
    public EmailService emailService;

//    @Test
    public void testCountUnread() {
        int unread = emailService.getUnreadNumber(1);
        System.out.println("Liczba nie przeczytanych maili: " + unread);
    }

//    @Test
    public void testGetMailBasicByPagination() {

    }

    @Test
    public void testGetFullEmail() {
        Email email = emailService.getFullEmail(1);

        System.out.println("Email: ");
        System.out.println(email.getSender());
        System.out.println(email.getContent());
        System.out.println(email.getId());
        System.out.println(email.getRecipients());
        System.out.println(email.getTopic());
    }

}

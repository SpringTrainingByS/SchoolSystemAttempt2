package pl.dn.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.dn.email.customBodies.EmailFull;
import pl.dn.email.customBodies.EmailShort;

import java.util.List;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "get/{emailId}", method = RequestMethod.GET)
    public EmailFull getById(@PathVariable long emailId) {
        return emailService.getFullEmail(emailId);
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public void send(@RequestBody Email email) {
        emailService.send(email);
    }

    @RequestMapping(value = "get-unread-count", params = "userId", method = RequestMethod.GET)
    public boolean checkUnread(@RequestParam("userId") int userId) {
        return emailService.checkUnread(userId);
    }

    @RequestMapping(value = "get-received", params = {"userId", "limit", "offset"}, method = RequestMethod.GET)
    public List<EmailShort> getReceivedEmails(@RequestParam("userId") long userId, @RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        return emailService.getReceivedEmailBasicsByPagination(limit, offset, userId);
    }

    @RequestMapping(value = "get/number", params = {"userId"}, method = RequestMethod.GET)
    public int getEmailsNumber(@RequestParam("userId") long userId) {
        return emailService.getEmailNumberForUser(userId);
    }

}

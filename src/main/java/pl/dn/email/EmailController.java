package pl.dn.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "email")
public class EmailController {

    private EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @RequestMapping(value = "send", method = RequestMethod.POST)
    public void send(@RequestBody Email email) {
        emailService.send(email);
    }

    @RequestMapping(value = "get-unread-count", method = RequestMethod.GET)
    public int checkUnread(@PathVariable long userId) {
        return 0;
    }

    @RequestMapping(value = "get-received", params = {"userId", "limit", "offset"}, method = RequestMethod.GET)
    public List<EmailShort> getReceivedEmails(@RequestParam("userId") long userId, @RequestParam("limit") int limit, @RequestParam("offset") int offset) {
        return emailService.getReceivedEmailBasicsByPagination(limit, offset, userId);
    }

}

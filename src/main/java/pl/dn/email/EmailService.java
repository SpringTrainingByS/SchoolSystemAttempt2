package pl.dn.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dn.email.customBodies.EmailShort;
import pl.dn.emailRecipients.EmailRecipientDao;
import pl.dn.emailRecipients.EmailRecipients;
import pl.dn.notification.EmailRead.EmailReadBool;
import pl.dn.notification.EmailRead.EmailReadDao;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmailService {

    private JavaMailSender javaMailSender;

    private EmailReadDao emailReadDao;

    private EmailDao emailDao;

    private EmailRecipientDao emailRecipientDao;

    @Autowired
    EmailService(JavaMailSender javaMailSender, EmailReadDao emailReadDao, EmailDao emailDao,
                        EmailRecipientDao emailRecipientDao) {
        this.javaMailSender = javaMailSender;
        this.emailReadDao = emailReadDao;
        this.emailDao = emailDao;
        this.emailRecipientDao = emailRecipientDao;
    }

    boolean checkUnread(long userId) {
        EmailReadBool emailReadBool = emailReadDao.findByUserId(userId);
        boolean isUnreadEmail = false;

        if (emailReadBool != null) {
            isUnreadEmail = emailReadBool.getIsToRead();
        }

        return isUnreadEmail;
    }

    void send(Email email) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper
                    .setTo(email
                            .getRecipients()
                            .stream()
                            .map(u -> u.getContactInfo().getEmail())
                            .toArray(String[]::new));
            helper.setReplyTo(email.getSender().getContactInfo().getEmail());
            helper.setFrom(email.getSender().getContactInfo().getEmail());
            helper.setSubject(email.getTopic());
            helper.setText(email.getContent(), true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }

    int getUnreadNumber(long userId) {

        boolean isEmailsToRead = emailReadDao.findByUserId(userId).getIsToRead();
        int emailToReadNumber = 0;

        if (isEmailsToRead) {
            emailToReadNumber = emailRecipientDao.countByRecipientIdAndIsRead(userId, false);
        }

        return emailToReadNumber;
    }

    List<EmailShort> getReceivedEmailBasicsByPagination(int limit, int offset, long userId) {
        List<EmailRecipients> emailRecipients = emailRecipientDao.findByUserIdUsePagination(limit, offset, userId);

        List<Long> emailsIds = emailRecipients.stream().map(u -> u.getEmail().getId()).collect(Collectors.toList());
        List<EmailShort> emailsShort = new ArrayList<>();

        for (long emailId : emailsIds) {
            boolean isRead = emailRecipientDao.checkEmailIsRead(emailId, userId);
            EmailShort email = emailDao.findById(emailId);
            email.setRead(isRead);
            emailsShort.add(email);
        }

        return emailsShort;
    }

    String getContentOnly(Long emailId) {
        return emailDao.getContentOnly(emailId);
    }

    int getEmailNumberForUser(long userId) {
        return emailRecipientDao.countByRecipientId(userId);
    }
}

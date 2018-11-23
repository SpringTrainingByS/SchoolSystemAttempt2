package pl.dn.email;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import pl.dn.emailRecipients.EmailRecipientDao;
import pl.dn.emailRecipients.EmailRecipients;
import pl.dn.emailShorter.EmailShorter;
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
    public EmailService(JavaMailSender javaMailSender, EmailReadDao emailReadDao, EmailDao emailDao,
                        EmailRecipientDao emailRecipientDao) {
        this.javaMailSender = javaMailSender;
        this.emailReadDao = emailReadDao;
        this.emailDao = emailDao;
        this.emailRecipientDao = emailRecipientDao;
    }

    public void send(Email email) {
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

    public int getUnreadNumber(long userId) {

        boolean isEmailsToRead = emailReadDao.findByUserId(userId).getIsToRead();
        int emailToReadNumber = 0;

        if (isEmailsToRead) {
            emailToReadNumber = emailRecipientDao.countByRecipientIdAndIsRead(userId, false);
        }

        return emailToReadNumber;
    }

    public List<Object> getReceivedEmailBasicsByPagination(int limit, int offset, long userId) {
        List<EmailRecipients> emailRecipients = emailRecipientDao.findByUserIdUsePagination(limit, offset, userId);

        System.out.println("Próba pobrania z bazy");

        List<Long> list = emailRecipients.stream().map(u -> u.getEmail().getId()).collect(Collectors.toList());
        List<Object> emails = new ArrayList<>();

        for(long id : list) {
            Object email = emailDao.findByIdWithShortSenderInfo(id);

            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            System.out.println(gson.toJson(email));
            System.out.println(email);
            emails.add(email);
        }

        return emails;
    }

    public Email getFullEmail(long id) {
        return emailDao.findFullById(id);
    }
}

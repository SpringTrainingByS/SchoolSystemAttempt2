package pl.dn.emailRecipients;

import pl.dn.email.Email;
import pl.dn.user.User;

import javax.persistence.*;
import java.util.List;

@Entity
public class EmailRecipients {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    private User recipient;

    @ManyToOne
    private Email email;

    private boolean isRead = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean getIsRead() {
        return isRead;
    }

    public void setIsRead(boolean read) {
        isRead = read;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }
}

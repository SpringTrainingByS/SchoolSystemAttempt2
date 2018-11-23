package pl.dn.notification.EmailRead;

import pl.dn.user.User;

import javax.persistence.*;

@Entity
public class EmailRead {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @OneToOne
    private User user;

    private boolean isToRead = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isToRead() {
        return isToRead;
    }

    public void setToRead(boolean toRead) {
        isToRead = toRead;
    }
}

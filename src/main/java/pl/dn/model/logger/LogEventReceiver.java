package pl.dn.model.logger;

import javax.persistence.*;

/**
 * Created by User on 17.08.2017.
 */
@Entity
@Table(name = "log_event_receiver")
public class LogEventReceiver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "log_event_id")
    private long logEventId;

    private boolean unread = false;

    public LogEventReceiver() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getLogEventId() {
        return logEventId;
    }

    public void setLogEventId(long logEventId) {
        this.logEventId = logEventId;
    }

    public boolean isUnread() {
        return unread;
    }

    public void setUnread(boolean unread) {
        this.unread = unread;
    }
}

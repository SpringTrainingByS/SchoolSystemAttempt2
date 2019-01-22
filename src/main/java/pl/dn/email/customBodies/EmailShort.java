package pl.dn.email.customBodies;
import com.fasterxml.jackson.annotation.JsonFormat;
import pl.dn.user.model.UserShort;

import java.util.Date;

public interface EmailShort {
    Long getId();

    UserShort getSender();
    String getTopic();
    String getShortContent();
    boolean getIsRead();
    void setRead(boolean read);

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Date getCreationTime();
}

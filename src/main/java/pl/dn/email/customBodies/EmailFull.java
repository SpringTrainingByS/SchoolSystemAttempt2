package pl.dn.email.customBodies;

import com.fasterxml.jackson.annotation.JsonFormat;
import pl.dn.user.UserShort;

import java.util.Date;

public interface EmailFull extends EmailCustom {
    Long getId();

    UserShort getSender();
    String getContent();
    String getTopic();
    String getShortContent();

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    Date getCreationTime();
}


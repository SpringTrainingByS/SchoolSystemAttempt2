package pl.dn.email;
import com.fasterxml.jackson.annotation.JsonFormat;
import pl.dn.user.UserShort;

import java.util.Date;

public interface EmailShort {
    Long getId();

    UserShort getSender();
//    String getSenderContactInfoEmail();
    String getContent();
    String getTopic();

    @JsonFormat
            (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    Date getCreationTime();
}


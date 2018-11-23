package pl.dn.email;

import java.util.Date;

public interface EmailBasic {
    Long getId();
    String getTopic();
    Date getCreationTime();
}

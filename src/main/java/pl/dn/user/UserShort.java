package pl.dn.user;

import pl.dn.contactInfo.UserContactShort;
import pl.dn.generalInfo.BasicInfoShort;

public interface UserShort {
    BasicInfoShort getBasicInfo();
    UserContactShort getContactInfo();
}

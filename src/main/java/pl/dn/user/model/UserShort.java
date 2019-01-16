package pl.dn.user.model;

import pl.dn.contactInfo.ContactInfoShort;
import pl.dn.generalInfo.BasicInfoShort;

public interface UserShort {
    ContactInfoShort getContactInfo();
    BasicInfoShort getBasicInfo();
}

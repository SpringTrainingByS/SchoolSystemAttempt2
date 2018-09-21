package pl.dn.user.dataCorrectness.nullCheck.contactInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;

@Service
public class ContactInfoChecker {

    private StringBuilder message;

    private NullMessages nullMessages;

    @Autowired
    public ContactInfoChecker(@Qualifier("ContactInfoNullMessages") NullMessages nullMessages) {
        this.nullMessages = nullMessages;
    }

    public StringBuilder checkContactInfo(UserContactInfo contactInfo, StringBuilder message) {

        this.nullMessages = new NullMessages();
        this.message = message;

        if (contactInfo == null) {
            this.message.append(nullMessages.getContactInfo());
        }
        else {
            checkNullsInsdieContactInfo(contactInfo);
        }

        return this.message;
    }

    private void checkNullsInsdieContactInfo(UserContactInfo contactInfo) {

        checkEmail(contactInfo.getEmail());
        checkPhoneNumber(contactInfo.getPhoneNumber());

        if (contactInfo.getAddress() == null) {
            message.append(nullMessages.getAddress());
        }
        else {
            checkAddressAndInsideIsNull(contactInfo.getAddress());
        }
    }

    private void checkEmail(String email) {
        if (email == null) {
            message.append(nullMessages.getEmail());
        }

    }

    private void checkPhoneNumber(String phoneNumber) {
        if (phoneNumber == null) {
            message.append(nullMessages.getPhoneNumber());
        }
    }

    private void checkAddressAndInsideIsNull(Address address) {

        System.out.println("Numer domu: " + address.getHouseNamber());
        System.out.println("Numer ap:" + address.getApartmentNumber());
        if (address.getHouseNamber() == 0) {
            message.append(nullMessages.getHouseNumber());
        }

        if (address.getApartmentNumber() == 0) {
            message.append(nullMessages.getApartmentNumber());
        }

        if (address.getCity() == null) {
            message.append(nullMessages.getCity());
        }

        if (address.getStreet() == null) {
            message.append(nullMessages.getStreet());
        }

        if (address.getVoivodeship() == null ) {
            message.append(nullMessages.getVoivodeship());
        }

        if (address.getZipCode() == null) {
            message.append(nullMessages.getZipCode());
        }

    }
}

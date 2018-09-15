package pl.dn.user.dataCorrectness.validation.contactInfo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.placeInfo.Address;
import pl.dn.user.dataCorrectness.validation.ValidationService;
import pl.dn.user.dataCorrectness.validation.base.ValidationPatterns;

@Service
public class ContactInfoValid {

    private InvalidMessages invalidMessages;
    private ValidationService validService;

    @Autowired
    public ContactInfoValid(ValidationService validService, @Qualifier("ContactInfoInvalidMessages") InvalidMessages invalidMessages) {
        this.invalidMessages = invalidMessages;
        this.validService = validService;
    }

    public StringBuilder valid(UserContactInfo contactInfo) {
        StringBuilder message = new StringBuilder();

        if (!validService.validEmail(contactInfo.getEmail())) {
            message.append(invalidMessages.email);
        }

        if (!validService.validPhoneNumber(contactInfo.getPhoneNumber())) {
            message.append(invalidMessages.phoneNumber);
        }

        message = validAddress(contactInfo.getAddress(), message);

        return message;
    }

    private StringBuilder validAddress(Address address, StringBuilder message) {

        if (!validService.validNumber(String.valueOf(address.getHouseNamber()))) {
            message.append(invalidMessages.houseNumber);
        }

        if (!validService.validNumber(String.valueOf(address.getApartmentNumber()))) {
            message.append(invalidMessages.apratmentNumber);
        }

        if (!validService.validZipode(address.getZipCode().getName())) {
            message.append(invalidMessages.zipCode);
        }

        if (!validService.validNameStartGreat(address.getCity().getName())) {
            message.append(invalidMessages.city);
        }

        if (!validService.validNameStartGreat(address.getStreet().getName())) {
            message.append(invalidMessages.street);
        }

        if (!validService.validName(address.getVoivodeship().getName())) {
            message.append(invalidMessages.voivodeship);
        }


        return message;
    }
}

package pl.dn.user.nullCheck.contactInfo;

import org.springframework.stereotype.Component;

@Component
public class NullMessages {

    private final String contactInfo = "Brak informacji kontaktowych.";
    private final String address = "Brak adresu kontaktowego.";
    private final String email = "Brak adresu email.";
    private final String phoneNumber = "Brak numeru telefonu.";
    private final String city = "Brak miasta.";
    private final String street = "Brak ulicy.";
    private final String voivodeship = "Brak województwa.";
    private final String zipCode = "Brak kodu pocztowego.";
    private final String houseNumber = "Brak numeru domu.";
    private final String apartmentNumber = "Brak numeru mieszkania.";

    public String getHouseNumber() {
        return houseNumber;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getVoivodeship() {
        return voivodeship;
    }

    public String getZipCode() {
        return zipCode;
    }
}

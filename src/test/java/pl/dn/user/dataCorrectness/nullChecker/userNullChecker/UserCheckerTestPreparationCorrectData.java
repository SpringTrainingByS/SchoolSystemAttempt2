package pl.dn.user.dataCorrectness.nullChecker.userNullChecker;

import pl.dn.bornInfo.UserBornInfo;
import pl.dn.contactInfo.UserContactInfo;
import pl.dn.generalInfo.BasicInfo;
import pl.dn.placeInfo.Address;
import pl.dn.placeInfo.city.City;
import pl.dn.placeInfo.street.Street;
import pl.dn.placeInfo.voivodeship.Voivodeship;
import pl.dn.placeInfo.zipCode.ZipCode;
import pl.dn.user.User;

import java.util.Date;

public class UserCheckerTestPreparationCorrectData {

    public User prepareCorrectUser() {
        User user = new User();

        user.setBasicInfo(prepareBasicInfo());
        user.setContactInfo(prepareContactInfo());
        user.setBornInfo(prepareBornInfo());

        return user;
    }

    private BasicInfo prepareBasicInfo() {
        BasicInfo basicInfo = new BasicInfo();

        basicInfo.setFirstName("");
        basicInfo.setLastName("");
        basicInfo.setPesel("");

        return basicInfo;
    }

    private UserContactInfo prepareContactInfo() {
        UserContactInfo contactInfo = new UserContactInfo();

        contactInfo.setEmail("");
        contactInfo.setPhoneNumber("");
        contactInfo.setAddress(prepareAddress());

        return contactInfo;
    }

    private UserBornInfo prepareBornInfo() {
        UserBornInfo bornInfo = new UserBornInfo();

        bornInfo.setCity(new City());
        bornInfo.setVoivodeship(new Voivodeship());
        bornInfo.setBornDate(new Date());

        return bornInfo;
    }

    private Address prepareAddress() {
        Address address = new Address();

        address.setVoivodeship(new Voivodeship());
        address.setZipCode(new ZipCode());
        address.setStreet(new Street());
        address.setCity(new City());
        address.setApartmentNumber(5);
        address.setHouseNamber(5);

        return address;
    }


}
